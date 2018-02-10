package com.flavienclara.cluedo.classes;

/**
 * Created by Clara on 09/02/2018.
 */

public class Groupe {
    public static final String TAG = Groupe.class.getSimpleName();
    public static final String TABLE = "Groupe";
    // Labels Table Columns names
    public static final String KEY_GroupeID = "GroupeId";
    public static final String KEY_GroupeNom = "GroupeNom";
    public static final String KEY_Pts = "nbPointGlobal";
    public static final String KEY_Code = "Code";

    private int id;
    private String nom;
    private int nbPoint;
    private int code;


    //constructeur vide
    public Groupe(){}


    //getter et setter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getNbPoint() {return nbPoint;}
    public void setNbPoint(int nbPoint) {this.nbPoint = nbPoint;}

    public int getCode() {return code;}
    public void setCode(int code) {this.code = code;}
}
