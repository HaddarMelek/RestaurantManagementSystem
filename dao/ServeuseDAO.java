// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import enums.StatutCommande;
import models.Commande;
import models.Menu;
import java.util.List;

public class ServeuseDAO extends UtilisateurDAO
{
    public List<Menu> ParcourirMenu() {
        new MenuDAO();
        return MenuDAO.Get();
    }
    
    public static int CommanderPlat(final Commande commande) {
        new CommandeDAO();
        return CommandeDAO.Create(commande);
    }
    
    public static List<Commande> AfficherCommande(final StatutCommande statut) {
        return new CommandeDAO().Get(statut);
    }
}
