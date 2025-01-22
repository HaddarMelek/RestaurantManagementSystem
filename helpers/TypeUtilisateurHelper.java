// 
// Decompiled by Procyon v0.6.0
// 

package helpers;

import enums.TypeUtilisateur;

public class TypeUtilisateurHelper
{
    public static TypeUtilisateur GetTypeUtilisateur(final int type) {
        switch (type) {
            case 2: {
                return TypeUtilisateur.SERVEUSE;
            }
            case 3: {
                return TypeUtilisateur.CUISINIER;
            }
            default: {
                return TypeUtilisateur.CUSTOMER;
            }
        }
    }
    
    public static int GetTypeUtilisateurNumber(final TypeUtilisateur type) {
        switch (type) {
            case SERVEUSE: {
                return 2;
            }
            case CUISINIER: {
                return 3;
            }
            default: {
                return 1;
            }
        }
    }
}
