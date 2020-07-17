package com.example.integrationtechnology;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import static android.app.AlertDialog.THEME_DEVICE_DEFAULT_DARK;

/* class Main ---- */
public class Impression1_1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impression1_1);
        Bundle extras = getIntent().getExtras();
        ImageView i = findViewById(R.id.img);
        if (extras != null) {
            int res = extras.getInt("resourseInt");
            i.setImageResource(res);
        }

        findViewById(R.id.impr1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.impr2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.impr3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.impr4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.impr5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.impr6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.impr7).setOnTouchListener(new MyTouchListener());

    }

    /* methode drag  ---------------- */
    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);
            } else {
                return false;
            }
            return true;
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




        /* -----Methode Gallery----- */
    public void gallery(View view) {
        final int GALLERY_REQUEST_CODE = 1;
        Intent date = new Intent(Intent.ACTION_PICK);
        date.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        date.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        startActivityForResult(date, GALLERY_REQUEST_CODE);
        int requestCode = -1;
        int resultCode = -1;
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    Uri selectedImage = date.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String imgDecodableString = cursor.getString(columnIndex);
                    cursor.close();
                    ImageView imageView = findViewById(R.id.add_image);
                    imageView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
                    break;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Hello Javatpoint", Toast.LENGTH_SHORT).show();
        }
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



