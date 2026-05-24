/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionmagasin;
import gestionmagasin.Models.DatabaseConnection;
import gestionmagasin.Vues.VueGestionMagasin;
/**
 *
 * @author arold
 */
public class GestionMagasin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VueGestionMagasin fenetre = new VueGestionMagasin();
        fenetre.setVisible(true);
        DatabaseConnection.getConnection();
        DatabaseConnection.closeConnection();
    }
    
}
