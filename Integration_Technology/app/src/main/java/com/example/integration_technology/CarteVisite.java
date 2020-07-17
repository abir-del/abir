package com.example.integration_technology;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CarteVisite extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_visite);

        final Spinner spinner= (Spinner) findViewById(R.id.spinner);
        String[] Type={"85X55 mm","87X57 mm","90X50 mm","92X52 mm"};
        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Type);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapterR);


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


    public void Click1(View view) {
        TextView increament =findViewById(R.id.increament);
        Integer count;
        count= Integer.valueOf(increament.getText().toString());
        if (count>100) {
            count = count - 100;
            increament.setText(String.valueOf(count));
        }
        else {
            Toast.makeText(getApplicationContext(), "Quantité min 100", Toast.LENGTH_SHORT).show();
        }
    }
    public void Click2(View view) {
        TextView increament =findViewById(R.id.increament);
        Integer count;
        count= Integer.valueOf(increament.getText().toString());
        if (count<2000) {
            count = count + 100;
            increament.setText(String.valueOf(count));
        }
        else {
            Toast.makeText(getApplicationContext(), "Quantité max 2000", Toast.LENGTH_SHORT).show();
        }
    }
}