/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionmagasin;
import gestionmagasin.Models.DatabaseConnection;
import gestionmagasin.Vues.VueGestionMagasin;
import gestionmagasin.Models.Marchandise;
import gestionmagasin.Controllers.ControllerMarchandise;
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
        Marchandise marchandise = new Marchandise("Gilette Blade", "Big blade for airstyle", 2500, 4);
        fenetre.setVisible(true);
        try {
            ControllerMarchandise.saveMarchandise(marchandise);
            DatabaseConnection.closePool();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
