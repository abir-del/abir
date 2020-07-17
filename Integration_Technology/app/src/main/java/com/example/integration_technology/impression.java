package com.example.integration_technology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class impression extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impression);
    }
// methodes de textile
    public void derection1(View view) {
        Intent intent = new Intent(this, Textile.class);
        intent.putExtra("resourseInt",R.drawable.tex1);
        startActivity(intent);
    }
    public void derection2(View view) {
        Intent intent = new Intent(this, Textile.class);
        intent.putExtra("resourseInt",R.drawable.tex2);
        startActivity(intent);
    }
    public void derection3(View view) {
        Intent intent = new Intent(this, Textile.class);
        intent.putExtra("resourseInt",R.drawable.tex3);
        startActivity(intent);
    }
    public void derection4(View view) {
        Intent intent = new Intent(this, Textile.class);
        intent.putExtra("resourseInt",R.drawable.tex4);
        startActivity(intent);
    }
    public void derection5(View view) {
        Intent intent = new Intent(this, Textile.class);
        intent.putExtra("resourseInt",R.drawable.tex5);
        startActivity(intent);
    }
    public void derection6(View view) {
        Intent intent = new Intent(this, Textile.class);
        intent.putExtra("resourseInt",R.drawable.tex6);
        startActivity(intent);
    }
    public void derection7(View view) {
        Intent intent = new Intent(this, Textile.class);
        intent.putExtra("resourseInt",R.drawable.tex7);
        startActivity(intent);
    }

    // methodes papeterie
    public void derection8(View view) {
        Intent intent = new Intent(this, BlocNote.class);
        startActivity(intent);
    }

    public void derection9(View view) {
        Intent intent = new Intent(this, CarteVisite.class);
        startActivity(intent);
    }
}
