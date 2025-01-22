// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import models.Commande;
import java.util.List;
import enums.StatutCommande;
import models.Menu;
import models.Plat;

public class CuisinierDAO extends UtilisateurDAO
{
    public static int ajouterPlat(final Plat plat) {
        new PlatDAO();
        return PlatDAO.create(plat);
    }
    
    public static boolean modifierPlat(final Plat plat) {
        new PlatDAO();
        return PlatDAO.Update(plat);
    }
    
    public static boolean supprimerPlat(final Plat plat) {
        new PlatDAO();
        return PlatDAO.delete(plat.getId());
    }
    
    public static boolean ajouterMenu(final Menu menu) {
        new MenuDAO();
        return MenuDAO.create(menu);
    }
    
    public static boolean modifierMenu(final Menu menu) {
        new MenuDAO();
        return MenuDAO.Update(menu);
    }
    
    public static boolean supprimerMenu(final int idMenu) {
        new MenuDAO();
        return MenuDAO.Delete(idMenu);
    }
    
    public static List<Commande> AfficherCommande(final StatutCommande statut) {
        return new CommandeDAO().Get(statut);
    }
    
    public static boolean modifierCommande(final Commande commande) {
        new CommandeDAO();
        return CommandeDAO.Update(commande);
    }
}
