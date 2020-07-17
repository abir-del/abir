package com.example.integration_technology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

    }

    public void GoTo1(View view) {
        Intent i = new Intent(services.this, impression.class);
        startActivity(i);
    }

    public void GoTo2(View view) {
        Intent i = new Intent(services.this, developpment.class);
        startActivity(i);
    }

    public void GoTo3(View view) {
        Intent i = new Intent(services.this, Design.class);
        startActivity(i);
    }

    public void GoTo4(View view) {
        Intent i = new Intent(services.this, Formations.class);
        startActivity(i);
    }
    public void GoTo5(View view) {
        Intent i = new Intent(services.this, Evenements.class);
        startActivity(i);
    }
}
