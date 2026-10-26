/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmagasin.Models;

/**
 *
 * @author arold
 */
public class Marchandise {
    // Creation of properties
    private int id_marchandise;
    private final String nom;    
    private final String designation;
    private final int prix_unitaire;
    private final int qte_en_stock;

    
    // creation of constructors
    // for loading the existings goods
    public Marchandise(int id_marchandise, String designation, int prix_unitaire, int qte_en_stock, String nom){
        this.id_marchandise = id_marchandise;
        this.nom = nom;        
        this.designation = designation;
        this.prix_unitaire = prix_unitaire;
        this.qte_en_stock = qte_en_stock;
    }
    
    // for loading a new goods
    public Marchandise(String nom, String designation, int prix_unitaire, int qte_en_stock){
        this.nom = nom;        
        this.designation = designation;
        this.prix_unitaire = prix_unitaire;
        this.qte_en_stock = qte_en_stock;
    }
    
    
    // Creation of getters
    public int getId_marchandise(){
        return this.id_marchandise;
    }

    public String getNom(){
        return this.nom;
    } 
    
    public String getDesignation(){
        return this.designation;
    }
    
    public int getPrix_unitaire(){
        return this.prix_unitaire;
    }
    
    public int getQte_en_stock(){
        return this.qte_en_stock;
    } 
}
