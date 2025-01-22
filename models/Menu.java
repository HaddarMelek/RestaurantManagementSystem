// 
// Decompiled by Procyon v0.6.0
// 

package models;

import java.util.List;

public class Menu
{
    private int id;
    private String nom;
    private List<MenuPlat> plats;
    
    public Menu() {
    }
    
    public Menu(final int id, final String nom) {
        this.setId(id);
        this.setNom(nom);
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(final String nom) {
        this.nom = nom;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.id) + "   " + this.nom;
    }
    
    public List<MenuPlat> getPlats() {
        return this.plats;
    }
    
    public void setPlats(final List<MenuPlat> plats) {
        this.plats = plats;
    }
}
