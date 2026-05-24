/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmagasin.Models;

import com.moandjiezana.toml.Toml;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author arold
 */
public class DatabaseConnection {
    private static Connection connection = null;
    public static Connection getConnection(){
        if(connection == null){
            try {
                File configFile = new File("config.toml");
                if(!configFile.exists()){
                    throw new RuntimeException("Le fichier config.toml est introuvable à la racine du projet.");
                }
                Toml toml = new Toml().read(configFile);
                String host = toml.getString("mysql_database.host");
                Long port = toml.getLong("mysql_database.port");
                String user = toml.getString("mysql_database.user");
                String database = toml.getString("mysql_database.database");
                String password = toml.getString("mysql_database.password");
                String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connexion à la base de données réussie !");
            }catch(ClassNotFoundException e){
                System.err.println("Pilote JDBC MySQL introuvable. Vérifiez votre connecteur JAR.");
                e.printStackTrace();
            }catch(SQLException e){
                System.err.println("Erreur lors de la connexion à la base de données.");
                e.printStackTrace();
            }catch(Exception e){
                System.err.println("Erreur lors de la lecture du fichier de configuration TOML.");
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
                connection = null;
                System.out.println("Connexion fermée avec succès.");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
