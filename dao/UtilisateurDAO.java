// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import models.Commande;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import helpers.TypeUtilisateurHelper;
import models.Utilisateur;

public class UtilisateurDAO
{
    public static Utilisateur Login(final String username, final String motDePasse) {
        final Connection connexion = SingletonConnection.getInstance();
        try {
            final PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM utilisateur WHERE username = ? AND motDePasse = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, motDePasse);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                final Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setUsername(resultSet.getString("username"));
                utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                utilisateur.setNomComplet(resultSet.getString("nomComplet"));
                utilisateur.setTel(resultSet.getString("tel"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setType(TypeUtilisateurHelper.GetTypeUtilisateur(resultSet.getInt("type")));
                return utilisateur;
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int Inscrire(final Utilisateur utilisateur) {
        int idUtilisateur = -1;
        final Connection conn = SingletonConnection.getInstance();
        try {
            final String query = "INSERT INTO Utilisateur(username , motDePasse, nomComplet, tel, adresse , type ) VALUES (?, ?, ?, ?, ?,?)";
            final PreparedStatement preparedStatement = conn.prepareStatement(query, 1);
            preparedStatement.setString(1, utilisateur.getUsername());
            preparedStatement.setString(2, utilisateur.getMotDePasse());
            preparedStatement.setString(3, utilisateur.getNomComplet());
            preparedStatement.setString(4, utilisateur.getTel());
            preparedStatement.setString(5, utilisateur.getAdresse());
            preparedStatement.setInt(6, TypeUtilisateurHelper.GetTypeUtilisateurNumber(utilisateur.getType()));
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                idUtilisateur = resultSet.getInt(1);
                utilisateur.setId(idUtilisateur);
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return idUtilisateur;
    }
    
    public static Utilisateur Profile(final int id) {
        final Utilisateur utilisateur = new Utilisateur();
        final Connection connection = SingletonConnection.getInstance();
        try {
            final String query = "SELECT username,motDePasse,nomComplet, tel, adresse, type FROM Utilisateur WHERE id =?";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                utilisateur.setId(id);
                utilisateur.setUsername(resultSet.getString("username"));
                utilisateur.setMotDePasse(resultSet.getString("motDePasse"));
                utilisateur.setNomComplet(resultSet.getString("nomComplet"));
                utilisateur.setTel(resultSet.getString("tel"));
                utilisateur.setAdresse(resultSet.getString("adresse"));
                utilisateur.setType(TypeUtilisateurHelper.GetTypeUtilisateur(resultSet.getInt("type")));
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return (utilisateur.getId() == 0) ? null : utilisateur;
    }
    
    public static List<Commande> AfficherCommande(final int idUtilisateur) {
        return new CommandeDAO().GetByCustomer(idUtilisateur);
    }
}
