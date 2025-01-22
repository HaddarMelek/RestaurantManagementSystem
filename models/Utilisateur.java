// 
// Decompiled by Procyon v0.6.0
// 

package models;

import enums.TypeUtilisateur;

public class Utilisateur
{
    private int id;
    private String username;
    private String nomComplet;
    private String motDePasse;
    private String tel;
    private String adresse;
    private TypeUtilisateur type;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getNomComplet() {
        return this.nomComplet;
    }
    
    public void setNomComplet(final String nomComplet) {
        this.nomComplet = nomComplet;
    }
    
    public String getMotDePasse() {
        return this.motDePasse;
    }
    
    public void setMotDePasse(final String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(final String tel) {
        this.tel = tel;
    }
    
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }
    
    public TypeUtilisateur getType() {
        return this.type;
    }
    
    public void setType(final TypeUtilisateur type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "id:" + this.id + "   " + "nomC" + this.nomComplet + "    " + "password:" + this.motDePasse + "    " + "tele" + this.tel + "   " + "adresse" + this.adresse + "   " + "type " + this.type;
    }
}
