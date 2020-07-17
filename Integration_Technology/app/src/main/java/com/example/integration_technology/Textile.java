package com.example.integration_technology;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;

import static android.app.AlertDialog.THEME_DEVICE_DEFAULT_DARK;

public class Textile extends AppCompatActivity implements View.OnDragListener, View.OnTouchListener {
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textile);
        Bundle extras = getIntent().getExtras();
        ImageView i = findViewById(R.id.img);
        if (extras != null) {
            int res = extras.getInt("resourseInt");
            i.setImageResource(res);
        }
        findViewById(R.id.impr1).getRootView().setOnDragListener(this);
        findViewById(R.id.impr1).getRootView().findViewById(R.id.main).setOnDragListener(this);
        findViewById(R.id.impr1).setOnTouchListener(this);findViewById(R.id.impr1).getRootView().setOnDragListener(this);
        findViewById(R.id.impr2).setOnTouchListener(this);findViewById(R.id.impr2).getRootView().setOnDragListener(this);
        findViewById(R.id.impr3).setOnTouchListener(this);findViewById(R.id.impr3).getRootView().setOnDragListener(this);
        findViewById(R.id.impr4).setOnTouchListener(this);findViewById(R.id.impr4).getRootView().setOnDragListener(this);
        findViewById(R.id.impr5).setOnTouchListener(this);findViewById(R.id.impr5).getRootView().setOnDragListener(this);
        findViewById(R.id.impr6).setOnTouchListener(this);findViewById(R.id.impr6).getRootView().setOnDragListener(this);
        findViewById(R.id.impr7).setOnTouchListener(this);findViewById(R.id.impr7).getRootView().setOnDragListener(this);

        ImageView buttonLoadImage = (ImageView) findViewById(R.id.add_image);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView buttonLoadImage = (ImageView) findViewById(R.id.add_image);
            buttonLoadImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }


    /* methode drag  ---------------- */

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DROP:

                float X = event.getX();
                float Y = event.getY();
                View view = (View) event.getLocalState();
                view.setX(X-(view.getWidth()/2));
                view.setY(Y-(view.getHeight()/2));
                view.setVisibility(View.VISIBLE);

            default:
                break;
        }
        return true;
    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(null, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);
                return true;
            } else {
                return false;
            }
        }




    /* Methode getDate ----------- */
    public void getDate(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        final TextView txtDate = findViewById(R.id.date);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, THEME_DEVICE_DEFAULT_DARK,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText("Date : "+dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    /* methode envoyer commande --------- */
    public void Envoyer(View view) {
        final TextView nomT  = (TextView) findViewById(R.id.nom);
        final TextView prenomT = (TextView) findViewById(R.id.prenom);
        final TextView mailT = (TextView) findViewById(R.id.mail);
        final TextView numtlfT = (TextView) findViewById(R.id.tel);
        final TextView quaT = (TextView) findViewById(R.id.quantite);
        final TextView remarqueT = (TextView) findViewById(R.id.cmnt);
        final TextView dateT = (TextView) findViewById(R.id.date);
        String nom = nomT.getText().toString();
        String prenom = prenomT.getText().toString();
        String mail = mailT.getText().toString();
        String numeroTel = numtlfT.getText().toString();
        String quantite = quaT.getText().toString();
        String remarque = remarqueT.getText().toString();
        String date = dateT.getText().toString();
        String Mymail = "Mazenkhchoum@gmail.com";
        String mdp ="12345678901mazen";

    }
}