// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import java.util.Iterator;
import models.MenuPlat;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Menu;
import java.util.List;

public class MenuDAO
{
    public static List<Menu> Get() {
        final List<Menu> menus = new ArrayList<Menu>();
        try {
            final Connection connexion = SingletonConnection.getInstance();
            final String sql = "SELECT * FROM menu";
            final PreparedStatement pstatement = connexion.prepareStatement(sql);
            final ResultSet resultats = pstatement.executeQuery();
            while (resultats.next()) {
                final Menu menu = new Menu(resultats.getInt("id"), resultats.getString("nom"));
                menus.add(menu);
            }
            pstatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }
    
    public static Menu Get(final int id) {
        final Menu menu = new Menu();
        try {
            final Connection connexion = SingletonConnection.getInstance();
            final String sql = "SELECT * FROM menu WHERE id =?";
            final PreparedStatement pstatement = connexion.prepareStatement(sql);
            pstatement.setInt(1, id);
            final ResultSet resultat = pstatement.executeQuery();
            if (resultat.next()) {
                menu.setId(id);
                menu.setNom(resultat.getString("nom"));
                final List<MenuPlat> plats = new ArrayList<MenuPlat>();
                final String query = "SELECT idPlat FROM menuplat WHERE idMenu = ?";
                final PreparedStatement preparedStatement = connexion.prepareStatement(query);
                preparedStatement.setInt(1, id);
                final ResultSet result = preparedStatement.executeQuery();
                while (result.next()) {
                    final MenuPlat menuPlat = new MenuPlat(id, result.getInt("idPlat"));
                    plats.add(menuPlat);
                }
                menu.setPlats(plats);
                pstatement.close();
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return (menu.getId() > 0) ? menu : null;
    }
    
    public static boolean create(final Menu menu) {
        Boolean added = false;
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String query = "INSERT INTO Menu (nom) VALUES (?)";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, menu.getNom());
            added = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return added;
    }
    
    public static boolean Update(final Menu menu) {
        boolean updated = false;
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String query = "Update Menu SET nom =? WHERE id=?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, menu.getNom());
            preparedStatement.setInt(2, menu.getId());
            updated = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
            if (updated) {
                final String subQuery = "DELETE  from menuplat WHERE idmenu= ? ";
                final PreparedStatement deleteAllStatement = connection.prepareStatement(subQuery);
                deleteAllStatement.setInt(1, menu.getId());
                deleteAllStatement.executeUpdate();
                deleteAllStatement.close();
                for (final MenuPlat plat : menu.getPlats()) {
                    final String sub = "INSERT INTO menuplat values (?,?)";
                    final PreparedStatement subPStatement = connection.prepareStatement(sub);
                    subPStatement.setInt(1, plat.getIdMenu());
                    subPStatement.setInt(2, plat.getIdPlat());
                    subPStatement.executeUpdate();
                    subPStatement.close();
                }
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
    
    public static boolean Delete(final int id) {
        boolean deleted = false;
        try {
            final Connection connexion = SingletonConnection.getInstance();
            final String sql = "Delete from menu where id =? ";
            final PreparedStatement pstatement = connexion.prepareStatement(sql);
            pstatement.setInt(1, id);
            deleted = (pstatement.executeUpdate() > 0);
            if (deleted) {
                final String subQuery = "DELETE  from menuplat WHERE idmenu= ? ";
                final PreparedStatement deleteAllStatement = connexion.prepareStatement(subQuery);
                deleteAllStatement.setInt(1, id);
                deleteAllStatement.executeUpdate();
                deleteAllStatement.close();
            }
            pstatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
