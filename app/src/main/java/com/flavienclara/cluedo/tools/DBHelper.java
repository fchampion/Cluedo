package com.flavienclara.cluedo.tools;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.flavienclara.cluedo.ADO.CategorieElementADO;
import com.flavienclara.cluedo.ADO.ElementADO;
import com.flavienclara.cluedo.ADO.GroupeADO;
import com.flavienclara.cluedo.classes.CategorieElement;
import com.flavienclara.cluedo.classes.Element;
import com.flavienclara.cluedo.classes.Groupe;

import static com.flavienclara.cluedo.activities.LoginActivity.getContext;

/**
 * Created by Julian on 16/01/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION =1;
    // Database Name
    private static final String DATABASE_NAME = "gestionBancaire.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper( ) {
        super(getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL(CategorieElementADO.createTable());
        db.execSQL(ElementADO.createTable());
        db.execSQL(GroupeADO.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + CategorieElement.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Element.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Groupe.TABLE);
        onCreate(db);
    }

}
