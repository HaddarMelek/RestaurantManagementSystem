// 
// Decompiled by Procyon v0.6.0
// 

package models;

public class Plat
{
    private int id;
    private String nom;
    private double prix;
    private String notes;
    
    public Plat() {
    }
    
    public Plat(final int id, final String nom, final double prix, final String notes) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.notes = notes;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(final String nom) {
        this.nom = nom;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public double getPrix() {
        return this.prix;
    }
    
    public void setPrix(final double prix) {
        this.prix = prix;
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(final String notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.id) + "    " + this.nom + "     " + this.prix + "     " + this.notes;
    }
}
