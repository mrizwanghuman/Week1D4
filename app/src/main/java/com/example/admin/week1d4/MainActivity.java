package com.example.admin.week1d4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
static final int imageCount =1;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = findViewById(R.id.mImage);

    }


    public void getPic(View view) {
        Intent takPicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takPicIntent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(takPicIntent,imageCount);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == imageCount && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImage.setImageBitmap(imageBitmap);
        }
    }

    public void imeCalculator(View view) {
        Intent intent= new Intent(this, Main2Activity.class );
        startActivity(intent);
    }
}
