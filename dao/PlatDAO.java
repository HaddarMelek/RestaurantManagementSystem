// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Plat;
import java.util.List;

public class PlatDAO
{
    public static List<Plat> getByMenu(final int idMenu) {
        final List<Plat> plats = new ArrayList<Plat>();
        final String query = "select * from plat where id in (select idPlat from menuplat where idMenu=?)";
        try {
            final Connection connection = SingletonConnection.getInstance();
            final PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idMenu);
            final ResultSet result = statement.executeQuery();
            while (result.next()) {
                final int id = result.getInt("id");
                final String nom = result.getString("nom");
                final double prix = result.getFloat("prix");
                final String notes = result.getString("notes");
                final Plat plat = new Plat(id, nom, prix, notes);
                plats.add(plat);
            }
            statement.close();
        }
        catch (final SQLException ex) {
            ex.printStackTrace();
        }
        return plats;
    }
    
    public static Plat get(final int id) {
        Plat plat = new Plat();
        final String query = "SELECT * FROM plat WHERE id = ?";
        try {
            final Connection connection = SingletonConnection.getInstance();
            final PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            final ResultSet result = statement.executeQuery();
            if (result.next()) {
                final String nom = result.getString("nom");
                final double prix = result.getFloat("prix");
                final String notes = result.getString("notes");
                plat = new Plat(id, nom, prix, notes);
            }
            result.close();
        }
        catch (final SQLException ex) {
            ex.printStackTrace();
        }
        return (plat.getId() > 0) ? plat : null;
    }
    
    public static int create(final Plat plat) {
        int idPlat = -1;
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String query = "INSERT INTO plat (nom , prix , notes) VALUES (? , ? , ? )";
            final PreparedStatement preparedStatement = connection.prepareStatement(query, 1);
            preparedStatement.setString(1, plat.getNom());
            preparedStatement.setDouble(2, plat.getPrix());
            preparedStatement.setString(3, plat.getNotes());
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idPlat = resultSet.getInt(1);
            }
            preparedStatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return idPlat;
    }
    
    public static boolean Update(final Plat plat) {
        boolean updated = false;
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String query = "Update Plat SET nom =? , prix=? , notes=?  where id=?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, plat.getNom());
            preparedStatement.setDouble(2, plat.getPrix());
            preparedStatement.setString(3, plat.getNotes());
            preparedStatement.setInt(4, plat.getId());
            updated = (preparedStatement.executeUpdate() > 0);
            preparedStatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
    
    public static boolean delete(final int id) {
        boolean deleted = false;
        try {
            final Connection connexion = SingletonConnection.getInstance();
            final String sql = "Delete from menuPlat where idPlat =? ";
            final String sql_1 = "Delete from plat where id =? ";
            final String sql_2 = "Delete from commandeplat where idPlat =? ";
            PreparedStatement pstatement = connexion.prepareStatement(sql);
            pstatement.setInt(1, id);
            pstatement.executeUpdate();
            pstatement = connexion.prepareStatement(sql_2);
            pstatement.setInt(1, id);
            pstatement.executeUpdate();
            pstatement = connexion.prepareStatement(sql_1);
            pstatement.setInt(1, id);
            pstatement.executeUpdate();
            deleted = (pstatement.executeUpdate() >= 0);
            pstatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
    
    public static JList<String> getItemListFromDatabase() {
        final DefaultListModel<String> listModel = new DefaultListModel<String>();
        try {
            final Connection connexion = SingletonConnection.getInstance();
            final String sql = "select nom   from plat  ";
            final PreparedStatement pstatement = connexion.prepareStatement(sql);
            Throwable t = null;
            try {
                final ResultSet rs = pstatement.executeQuery();
                try {
                    while (rs.next()) {
                        final String nomPlat = rs.getString("nom");
                        listModel.addElement(nomPlat);
                    }
                }
                finally {
                    if (rs != null) {
                        rs.close();
                    }
                }
            }
            finally {
                if (t == null) {
                    final Throwable exception;
                    t = exception;
                }
                else {
                    final Throwable exception;
                    if (t != exception) {
                        t.addSuppressed(exception);
                    }
                }
            }
            pstatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        final JList<String> platsList = new JList<String>(listModel);
        return platsList;
    }
}
