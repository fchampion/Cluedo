package com.flavienclara.cluedo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.flavienclara.cluedo.R;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
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
