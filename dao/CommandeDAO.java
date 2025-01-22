// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import java.util.ArrayList;
import java.util.List;
import enums.StatutCommande;
import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import models.CommandePlat;
import java.sql.Date;
import helpers.StatutCommandeHelper;
import models.Commande;

public class CommandeDAO
{
    public static int Create(final Commande commande) {
        int idCommande = -1;
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String query = "INSERT INTO Commande (idUtilisateur,statut,total,dateCreation,notes) VALUES (?,?,?, ?, ?)";
            final PreparedStatement preparedStatement = connection.prepareStatement(query, 1);
            preparedStatement.setInt(1, commande.getIdUtilisateur());
            preparedStatement.setInt(2, StatutCommandeHelper.GetStatutCommandeNumber(commande.getStatut()));
            preparedStatement.setDouble(3, commande.getTotal());
            preparedStatement.setDate(4, new Date(commande.getDateCreation().getTime()));
            preparedStatement.setString(5, commande.getNotes());
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idCommande = resultSet.getInt(1);
                final String subQuery = "INSERT INTO CommandePlat (idCommande,idPlat,quantite) VALUES (?,?,?)";
                final PreparedStatement subPreparedStatement = connection.prepareStatement(subQuery);
                for (final CommandePlat plat : commande.getPlats()) {
                    subPreparedStatement.setInt(1, idCommande);
                    subPreparedStatement.setInt(2, plat.getIdPlat());
                    subPreparedStatement.setInt(3, plat.getQuantite());
                    subPreparedStatement.executeUpdate();
                }
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return idCommande;
    }
    
    public static boolean Update(final Commande commande) {
        int modifies = -1;
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String query = "UPDATE Commande SET idUtilisateur = ?,statut = ?,total = ?,notes = ? WHERE id = ?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, commande.getIdUtilisateur());
            preparedStatement.setInt(2, StatutCommandeHelper.GetStatutCommandeNumber(commande.getStatut()));
            preparedStatement.setDouble(3, commande.getTotal());
            preparedStatement.setString(4, commande.getNotes());
            preparedStatement.setInt(5, commande.getId());
            modifies = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return modifies > 0;
    }
    
    public List<Commande> Get(final StatutCommande statut) {
        final List<Commande> commandes = new ArrayList<Commande>();
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String sql = "SELECT * FROM commande where statut= ? ";
            final PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, StatutCommandeHelper.GetStatutCommandeNumber(statut));
            final ResultSet resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final int idUtilisateur = resultSet.getInt("idUtilisateur");
                final double total = resultSet.getDouble("total");
                final Date dateCreation = resultSet.getDate("dateCreation");
                final String notes = resultSet.getString("notes");
                final Commande commande = new Commande(id, idUtilisateur, statut, total, dateCreation, notes);
                commandes.add(commande);
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }
    
    public List<Commande> GetByCustomer(final int idUtilisateur) {
        final List<Commande> commandes = new ArrayList<Commande>();
        try {
            final Connection connection = SingletonConnection.getInstance();
            final String sql = "SELECT * FROM commande where idUtilisateur= ? ";
            final PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, idUtilisateur);
            final ResultSet resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final double total = resultSet.getDouble("total");
                final Date dateCreation = resultSet.getDate("dateCreation");
                final String notes = resultSet.getString("notes");
                final StatutCommande statut = StatutCommandeHelper.GetStatutCommande(resultSet.getInt("statut"));
                final Commande commande = new Commande(id, idUtilisateur, statut, total, dateCreation, notes);
                commandes.add(commande);
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }
    
    public static Commande Get(final int id) {
        try {
            final Connection connexion = SingletonConnection.getInstance();
            final String sql = "SELECT * FROM Commande WHERE id =?";
            final PreparedStatement pstatement = connexion.prepareStatement(sql);
            pstatement.setInt(1, id);
            final ResultSet resultat = pstatement.executeQuery();
            if (resultat.next()) {
                final Commande commande = new Commande(id, resultat.getInt("idUtilisateur"), StatutCommandeHelper.GetStatutCommande(resultat.getInt("statut")), resultat.getDouble("total"), resultat.getDate("dateCreation"), resultat.getString("notes"));
                final String query = "select * From commandeplat where idCommande = ?";
                final PreparedStatement preparedStatement = connexion.prepareStatement(query);
                preparedStatement.setInt(1, id);
                final ResultSet subResult = preparedStatement.executeQuery();
                final List<CommandePlat> plats = new ArrayList<CommandePlat>();
                while (subResult.next()) {
                    final CommandePlat commandePlat = new CommandePlat(id, subResult.getInt("idPlat"), subResult.getInt("quantite"));
                    plats.add(commandePlat);
                }
                commande.setPlats(plats);
                preparedStatement.close();
                return commande;
            }
            pstatement.close();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean delete(final int id) {
        boolean deleted = false;
        try {
            final Connection connexion = SingletonConnection.getInstance();
            final String sql = "Delete from commandeplat where idCommande =? ";
            final String sql_2 = "Delete from commande where id =? ";
            PreparedStatement pstatement = connexion.prepareStatement(sql);
            pstatement.setInt(1, id);
            pstatement.executeUpdate();
            pstatement = connexion.prepareStatement(sql_2);
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
}
