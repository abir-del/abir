package com.example.integration_technology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dev_Web extends AppCompatActivity {
    EditText descr;
    EditText tel;
    EditText nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev__web);
        descr = findViewById(R.id.desc);
        tel = findViewById(R.id.tel);
        nom = findViewById(R.id.nom);
        Button send = findViewById(R.id.ccc);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = "Integration.technology.med@gmail.com";
                String subject = "Demander Devis \"Application Web\"";
                String message ="// "+nom.getText().toString() + " " + tel.getText().toString()+ " // " + "\n" + descr.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

    }
}
