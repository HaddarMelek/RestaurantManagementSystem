// 
// Decompiled by Procyon v0.6.0
// 

package helpers;

import enums.StatutCommande;

public class StatutCommandeHelper
{
    public static StatutCommande GetStatutCommande(final int type) {
        switch (type) {
            case 1: {
                return StatutCommande.CREATED;
            }
            case 2: {
                return StatutCommande.INPROGRESS;
            }
            case 3: {
                return StatutCommande.COMPLETED;
            }
            case 4: {
                return StatutCommande.CANCLED;
            }
            default: {
                return StatutCommande.CREATED;
            }
        }
    }
    
    public static int GetStatutCommandeNumber(final StatutCommande type) {
        switch (type) {
            case CREATED: {
                return 1;
            }
            case INPROGRESS: {
                return 2;
            }
            case COMPLETED: {
                return 3;
            }
            case CANCLED: {
                return 4;
            }
            default: {
                return 1;
            }
        }
    }
}
