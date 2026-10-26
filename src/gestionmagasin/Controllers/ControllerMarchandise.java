/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmagasin.Controllers;

import java.sql.PreparedStatement;
import gestionmagasin.Models.Marchandise;
import gestionmagasin.Models.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author arold
 */
public class ControllerMarchandise {
    /**
     * Insert a merchandise into a database.
     * @param marchandise The merchandise to save into the database.
     * @throws SQLException If the query generate an error.
     */
    public static void saveMarchandise(Marchandise marchandise) throws SQLException{
        String insert = "INSERT INTO marchandise(nom, designation, prix_unitaire, qte_en_stock) VALUES(?, ?, ?, ?);";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(insert)) {
            statement.setString(1, marchandise.getNom());
            statement.setString(2, marchandise.getDesignation());
            statement.setInt(3, marchandise.getPrix_unitaire());
            statement.setInt(4, marchandise.getQte_en_stock());
            statement.executeUpdate();            
        }
    }
}
