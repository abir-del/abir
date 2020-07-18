package com.example.integration_technology;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.integration_technology.R;

import java.util.Locale;

public class contacte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacte);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView tel= (ImageView) findViewById(R.id.tel);
        tel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "94234988"));
                startActivity(i);
            }
        });

        ImageView tel2= (ImageView) findViewById(R.id.tel2);
        tel2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "75640221"));
                startActivity(i);
            }
        });

        ImageView adr= (ImageView) findViewById(R.id.adr);
        adr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 33.34569044982658,10.491351096270591);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });


        ImageView mail= (ImageView) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_EMAIL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//Min SDK 15
                startActivity(intent);

            }
        });

    }

}
