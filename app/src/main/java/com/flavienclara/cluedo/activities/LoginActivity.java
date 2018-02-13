package com.flavienclara.cluedo.activities;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.flavienclara.cluedo.R;
import com.flavienclara.cluedo.classes.Groupe;
import com.flavienclara.cluedo.classes.CategorieElement;
import com.flavienclara.cluedo.classes.Element;

import com.flavienclara.cluedo.ADO.CategorieElementADO;
import com.flavienclara.cluedo.ADO.ElementADO;
import com.flavienclara.cluedo.ADO.GroupeADO;

import com.flavienclara.cluedo.tools.DBHelper;
import com.flavienclara.cluedo.tools.DatabaseManager;

import java.util.ArrayList;

/**
 * Created by Clara on 09/02/2018.
 */

public class LoginActivity extends AppCompatActivity {
    public static Groupe connected;
    public ArrayList<Groupe> lesGroupes;
    private static Context context;
    private static DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getApplicationContext();
        dbHelper = new DBHelper();
        DatabaseManager.initializeInstance(dbHelper);

        insertSQLiteData();


        if(connected != null){
            setContentView(R.layout.activity_logout);
            Button btnLogout = (Button) findViewById(R.id.btn_logout);
            TextView labelProfil = (TextView) findViewById(R.id.label_profil);
            labelProfil.setText(" Voulez-vous vous déconnecter ?");
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    connected = null;
                    Intent i = new Intent(LoginActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            });
        }else {
            setContentView(R.layout.activity_login);
            final EditText code = (EditText) findViewById(R.id.input_code);
            final Button btnConnexion = (Button) findViewById(R.id.btn_conn);
            final TextView error = (TextView) findViewById(R.id.error_auth);

            btnConnexion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    error.setText("");
                    //si le champ code est vide
                    if (code.getText().toString().equals("")) {
                        error.setText("Veuillez remplir tous les champs.");
                    } else {
                        //parcours les groupes
                        for (Groupe g : lesGroupes) {
                            //si le code du groupe = code entré
                            if (String.valueOf(g.getCode()).equals(code.getText())) {
                                //setCode(g);
                                //on ouvre l'intent  (Remplacer Activity par L'activité de la liste d'acceuil)
                                Intent i = new Intent(LoginActivity.this, ListActivity.class);
                                startActivity(i);
                                //sinon on affiche code incorrect
                            } else {
                                error.setText("Code incorrect.");
                            }
                        }

                    }
                    //A retirer pour eviter la connexion
                    Intent i = new Intent(LoginActivity.this, ListActivity.class);
                    startActivity(i);
                }
            });
        }
    }

    public static Context getContext(){
        return context;
    }

    public void insertSQLiteData(){

        CategorieElementADO catADO = new CategorieElementADO();
        ElementADO elementADO = new ElementADO();
        GroupeADO groupeADO = new GroupeADO();


        //création des groupes
        Groupe grp1 = new Groupe();
        grp1.setNom("Groupe1");
        grp1.setNbPoint(0);
        grp1.setCode(546135);
        grp1.setId(groupeADO.insert(grp1));

        //création des categories d'elements
        CategorieElement cat1 = new CategorieElement();
        cat1.setNom("Personnages");
        cat1.setId(catADO.insert(cat1));

        CategorieElement cat2 = new CategorieElement();
        cat2.setNom("Armes");
        cat2.setId(catADO.insert(cat2));

        CategorieElement cat3 = new CategorieElement();
        cat3.setNom("Lieux");
        cat3.setId(catADO.insert(cat3));

        //créations d'elements Personnages
        Element e1 = new Element();
        e1.setNom("Léopold Amploit");
        e1.setCategorieId(cat1.getId());
        e1.setId(elementADO.insert(e1));

        Element e2 = new Element();
        e2.setNom("Captain Morgan");
        e2.setCategorieId(cat1.getId());
        e2.setId(elementADO.insert(e2));

        Element e3 = new Element();
        e3.setNom("Hanibal Serveur");
        e3.setCategorieId(cat1.getId());
        e3.setId(elementADO.insert(e3));

        Element e4 = new Element();
        e4.setNom("Hejaren Enudden");
        e4.setCategorieId(cat1.getId());
        e4.setId(elementADO.insert(e4));

        Element e5 = new Element();
        e5.setNom("Alexandra Ledermann");
        e5.setCategorieId(cat1.getId());
        e5.setId(elementADO.insert(e5));

        Element e6 = new Element();
        e6.setNom("Soeur Marie-Thérèse");
        e6.setCategorieId(cat1.getId());
        e6.setId(elementADO.insert(e6));


        //créations d'elements Armes
        Element a1 = new Element();
        a1.setNom("Coupe papier");
        a1.setCategorieId(cat2.getId());
        a1.setId(elementADO.insert(a1));

        Element a2 = new Element();
        a2.setNom("Café empoisonné");
        a2.setCategorieId(cat2.getId());
        a2.setId(elementADO.insert(a2));

        Element a3 = new Element();
        a3.setNom("Chaussure à talon");
        a3.setCategorieId(cat2.getId());
        a3.setId(elementADO.insert(a3));

        Element a4 = new Element();
        a4.setNom("Lance patate");
        a4.setCategorieId(cat2.getId());
        a4.setId(elementADO.insert(a4));

        Element a5 = new Element();
        a5.setNom("Nokia 3310");
        a5.setCategorieId(cat2.getId());
        a5.setId(elementADO.insert(a5));

        Element a6 = new Element();
        a6.setNom("Câble réseau");
        a6.setCategorieId(cat2.getId());
        a6.setId(elementADO.insert(a6));

        //créations d'elements Lieux
        Element l1 = new Element();
        l1.setNom("Collegiale");
        l1.setCategorieId(cat3.getId());
        l1.setId(elementADO.insert(l1));

        Element l2 = new Element();
        l2.setNom("CDI");
        l2.setCategorieId(cat3.getId());
        l2.setId(elementADO.insert(l2));

        Element l3 = new Element();
        l3.setNom("Salle des Archives");
        l3.setCategorieId(cat3.getId());
        l3.setId(elementADO.insert(l3));

        Element l4 = new Element();
        l4.setNom("Machine à café");
        l4.setCategorieId(cat3.getId());
        l4.setId(elementADO.insert(l4));

        Element l5 = new Element();
        l5.setNom("Bureau de la directrice");
        l5.setCategorieId(cat3.getId());
        l5.setId(elementADO.insert(l5));

        Element l6 = new Element();
        l6.setNom("Gymnase");
        l6.setCategorieId(cat3.getId());
        l6.setId(elementADO.insert(l6));

        Element l7 = new Element();
        l7.setNom("Toilettes B13");
        l7.setCategorieId(cat3.getId());
        l7.setId(elementADO.insert(l7));

        Element l8 = new Element();
        l8.setNom("Salle examen");
        l8.setCategorieId(cat3.getId());
        l8.setId(elementADO.insert(l8));

        Element l9 = new Element();
        l9.setNom("Voiture");
        l9.setCategorieId(cat3.getId());
        l9.setId(elementADO.insert(l9));

        Element l10 = new Element();
        l10.setNom("Ateliers");
        l10.setCategorieId(cat3.getId());
        l10.setId(elementADO.insert(l10));

    }

}

