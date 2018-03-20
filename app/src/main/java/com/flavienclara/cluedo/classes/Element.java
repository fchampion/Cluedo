package com.flavienclara.cluedo.classes;

/**
 * Created by Clara on 09/02/2018.
 */

public class Element {

        public static final String TAG = Element.class.getSimpleName();
        public static final String TABLE = "Element";
        // Labels Table Columns names
        public static final String KEY_ElementID = "ElementId";
        public static final String KEY_ElementNom = "ElementNom";
        public static final String KEY_CategorieID = "FkCategorieId";

        private int id;
        private String nom;
        private int categorieId;

    //constructeur vide
    public Element() {}

    //getter et setter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getCategorieId() {return categorieId;}
    public void setCategorieId(int categorieId) {this.categorieId = categorieId;}
}
