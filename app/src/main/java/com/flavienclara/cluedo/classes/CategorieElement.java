package com.flavienclara.cluedo.classes;

/**
 * Created by Clara on 09/02/2018.
 */

public class CategorieElement {

    public static final String TAG = CategorieElement.class.getSimpleName();
    public static final String TABLE = "CategorieElement";
    // Labels Table Columns names
    public static final String KEY_CategorieElementID = "CategorieElementId";
    public static final String KEY_CategorieElementNom = "CategorieElementNom";

    private int id;
    private String nom;

    //constructeur vide
    public CategorieElement() {}

    //getter et setter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

}

