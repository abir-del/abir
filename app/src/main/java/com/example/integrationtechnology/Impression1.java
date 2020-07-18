package com.example.integrationtechnology;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class Impression1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impression1);
    }

    public void goToo1(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr1);
        startActivity(intent);
    }
    public void goToo2(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr2);
        startActivity(intent);
    }
    public void goToo3(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr3);
        startActivity(intent);
    }
    public void goToo4(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr4);
        startActivity(intent);
    }
    public void goToo5(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr5);
        startActivity(intent);
    }
    public void goToo6(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr6);
        startActivity(intent);
    }
    public void goToo7(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr7);
        startActivity(intent);
    }
    public void goToo8(View view) {
        Intent intent = new Intent(this, Impression1_1.class);
        intent.putExtra("resourseInt",R.drawable.impr8);
        startActivity(intent);
    }
}
