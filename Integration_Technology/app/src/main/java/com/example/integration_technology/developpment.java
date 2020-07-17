package com.example.integration_technology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class developpment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developpment);
    }

    public void devMob(View view) {
        Intent i = new Intent(developpment.this,dev_Mobile.class);
        startActivity(i);
    }
    public void devWeb(View view) {
        Intent i = new Intent(developpment.this,dev_Web.class);
        startActivity(i);
    }
    public void devApp(View view) {
        Intent i = new Intent(developpment.this,dev_App.class);
        startActivity(i);
    }
}