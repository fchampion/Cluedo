package com.flavienclara.cluedo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;

import com.flavienclara.cluedo.R;
import com.flavienclara.cluedo.ADO.ElementADO;
import com.flavienclara.cluedo.classes.Element;
import com.flavienclara.cluedo.tools.RecyclerViewElementAdapter;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {
    //recycler view
    private RecyclerView recyclerViewPersonnage;
    private RecyclerView recyclerViewArme;
    private RecyclerView recyclerViewLieu;
    public static Element element;
    public ArrayList<Element> lesElements = new ArrayList<Element>();
    public ArrayList<Element> lesPersonnages = new ArrayList<Element>();
    public ArrayList<Element> lesArmes = new ArrayList<Element>();
    public ArrayList<Element> lesLieux = new ArrayList<Element>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //lien avec la BDD pour récupérer tous les elements
        ElementADO elemAdo = new ElementADO();
        lesElements=elemAdo.getAllElements();

        //pour chaque elements -> tri par categorie
        for (Element e : lesElements){
            if (e.getCategorieId()==1){
                lesPersonnages.add(e);
            }
            if (e.getCategorieId()==2){
                lesArmes.add(e);
            }
            if (e.getCategorieId()==3){
                lesLieux.add(e);
            }
        }

        //recycler view personnages
        recyclerViewPersonnage = (RecyclerView)findViewById(R.id.my_recycler_view_personnage);
        recyclerViewPersonnage.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPersonnage.setLayoutManager(linearLayoutManager);
        recyclerViewPersonnage.setAdapter(new RecyclerViewElementAdapter(lesPersonnages, new RecyclerViewElementAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Element item) {
                element =item;
            }
        }));

        //afficher dans la recyclerview la liste des lieux
        recyclerViewArme = (RecyclerView)findViewById(R.id.my_recycler_view_arme);
        recyclerViewArme.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        recyclerViewArme.setLayoutManager(linearLayoutManager2);
        recyclerViewArme.setAdapter(new RecyclerViewElementAdapter(lesArmes, new RecyclerViewElementAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Element item) {
                element =item;
            }
        }));

        recyclerViewLieu = (RecyclerView)findViewById(R.id.my_recycler_view_lieu);
        recyclerViewLieu.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        recyclerViewLieu.setLayoutManager(linearLayoutManager3);
        recyclerViewLieu.setAdapter(new RecyclerViewElementAdapter(lesLieux, new RecyclerViewElementAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Element item) {
                element =item;
            }
        }));




        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_item, menu);
        return true;

    } //actions sur éléments toolbar
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.item_camera:
                intent = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(intent);
                return  true;
            case R.id.item_liste:
                intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
                return  true;

        }
        return super.onOptionsItemSelected(item);
    }
}
