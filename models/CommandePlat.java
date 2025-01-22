// 
// Decompiled by Procyon v0.6.0
// 

package models;

public class CommandePlat
{
    private int idCommande;
    private int idPlat;
    private int quantite;
    
    public CommandePlat(final int idCommande, final int idPlat, final int quantite) {
        this.idCommande = idCommande;
        this.idPlat = idPlat;
        this.quantite = quantite;
    }
    
    public int getIdCommande() {
        return this.idCommande;
    }
    
    public void setIdCommande(final int idCommande) {
        this.idCommande = idCommande;
    }
    
    public int getIdPlat() {
        return this.idPlat;
    }
    
    public void setIdPlat(final int idPlat) {
        this.idPlat = idPlat;
    }
    
    public int getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(final int quantite) {
        this.quantite = quantite;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.idCommande) + "   " + this.idPlat + "    " + this.quantite;
    }
}
