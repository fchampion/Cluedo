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
import com.flavienclara.cluedo.classes.CategorieElement;
import com.flavienclara.cluedo.classes.Element;
import com.flavienclara.cluedo.tools.RecyclerViewElementAdapter;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {
    //recycler view
    private RecyclerView recyclerView;
    public static Element element;
    public ArrayList<Element> lesElements = new ArrayList<Element>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ElementADO elemAdo = new ElementADO();
        lesElements=elemAdo.getAllElements();

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecyclerViewElementAdapter(lesElements, new RecyclerViewElementAdapter.OnItemClickListener() {
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
                //intent = new Intent(getApplicationContext(), LoginActivity.class);
                //startActivity(intent);
                return  true;
            case R.id.item_liste:
                //intent = new Intent(getApplicationContext(), CompteActivity.class);
                //startActivity(intent);
                return  true;

        }
        return super.onOptionsItemSelected(item);
    }
}
