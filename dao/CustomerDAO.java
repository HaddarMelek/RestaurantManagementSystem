// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import models.Commande;
import models.Menu;
import java.util.List;

public class CustomerDAO extends UtilisateurDAO
{
    public List<Menu> ParcourirMenu() {
        new MenuDAO();
        return MenuDAO.Get();
    }
    
    public int CommanderPlat(final Commande commande) {
        new CommandeDAO();
        return CommandeDAO.Create(commande);
    }
}
