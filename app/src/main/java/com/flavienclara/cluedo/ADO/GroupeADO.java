package com.flavienclara.cluedo.ADO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flavienclara.cluedo.classes.Groupe;
import com.flavienclara.cluedo.tools.DatabaseManager;

import java.util.ArrayList;

/**
 * Created by flavien.champion on 10/02/2018.
 */

public class GroupeADO {


    private Groupe groupe;

    public GroupeADO(){
        groupe = new Groupe();
    }

    public static String createTable(){
        return "CREATE TABLE " + Groupe.TABLE  + "("
                + Groupe.KEY_GroupeID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Groupe.KEY_GroupeNom + " TEXT, "
                + Groupe.KEY_Code + " INTEGER, "
                + Groupe.KEY_Pts   + " INTEGER )";
    }

    public int insert(Groupe groupe) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Groupe.KEY_Code, groupe.getCode());
        values.put(Groupe.KEY_GroupeNom, groupe.getNom());
        values.put(Groupe.KEY_Pts, groupe.getNbPoint());
        // Inserting Row
        long id = db.insert(groupe.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return (int)id;
    }
    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Groupe.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public ArrayList<Groupe> getAllElements() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor c = db.query(Groupe.TABLE, new String[] {}, null, null, null, null, Groupe.KEY_GroupeID);
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        ArrayList<Groupe> groupeList = new
                ArrayList<Groupe> ();
        while (c.moveToNext()) {
            Groupe groupe = new Groupe();
            groupe.setId(c.getInt(0));
            groupe.setNom(c.getString(1));
            groupe.setNbPoint(c.getInt(2));
            groupe.setCode(c.getInt(3));
            groupeList.add(groupe);
        }
        c.close();
        return groupeList;
    }
}
