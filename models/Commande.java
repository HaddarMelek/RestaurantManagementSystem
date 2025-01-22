// 
// Decompiled by Procyon v0.6.0
// 

package models;

import java.util.List;
import java.util.Date;
import enums.StatutCommande;

public class Commande
{
    private int id;
    private int idUtilisateur;
    private StatutCommande statut;
    private double total;
    private Date dateCreation;
    private String notes;
    private List<CommandePlat> plats;
    
    public Commande() {
    }
    
    public Commande(final int id, final int idUtilisateur, final StatutCommande statut, final double total, final Date dateCreation, final String notes) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.statut = statut;
        this.total = total;
        this.dateCreation = dateCreation;
        this.notes = notes;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getIdUtilisateur() {
        return this.idUtilisateur;
    }
    
    public void setIdUtilisateur(final int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    public StatutCommande getStatut() {
        return this.statut;
    }
    
    public void setStatut(final StatutCommande statut) {
        this.statut = statut;
    }
    
    public double getTotal() {
        return this.total;
    }
    
    public void setTotal(final double total) {
        this.total = total;
    }
    
    public Date getDateCreation() {
        return this.dateCreation;
    }
    
    public void setDateCreation(final Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(final String notes) {
        this.notes = notes;
    }
    
    public List<CommandePlat> getPlats() {
        return this.plats;
    }
    
    public void setPlats(final List<CommandePlat> plats) {
        this.plats = plats;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.id) + "   " + this.idUtilisateur + "   " + this.statut + "   " + this.total + "   " + this.dateCreation + "   " + this.notes + "   " + this.plats;
    }
    
    public String getDetails() {
        return String.valueOf(this.id) + " - " + this.total + " - " + this.dateCreation;
    }
}
