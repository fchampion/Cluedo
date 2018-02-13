package com.flavienclara.cluedo.activities;


import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by flavien.champion on 13/02/2018.
 */

import com.flavienclara.cluedo.R;



public class ScanActivity extends AppCompatActivity {

    public static TextView tvresult;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        tvresult = (TextView) findViewById(R.id.tvresult);

        btn = (Button) findViewById(R.id.btn_scan);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScanActivity.this, QrreaderActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_item, menu);
        return true;

    } //actions sur éléments toolbar

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.item_camera:
                intent = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_liste:
                intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}