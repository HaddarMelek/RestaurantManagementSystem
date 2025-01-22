// 
// Decompiled by Procyon v0.6.0
// 

package models;

public class MenuPlat
{
    private int idMenu;
    private int idPlat;
    
    public MenuPlat() {
    }
    
    public MenuPlat(final int idMenu, final int idPlat) {
        this.idMenu = idMenu;
        this.idPlat = idPlat;
    }
    
    public int getIdMenu() {
        return this.idMenu;
    }
    
    public void setIdMenu(final int idMenu) {
        this.idMenu = idMenu;
    }
    
    public int getIdPlat() {
        return this.idPlat;
    }
    
    public void setIdPlat(final int idPlat) {
        this.idPlat = idPlat;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.idMenu) + "   " + this.idPlat;
    }
}
