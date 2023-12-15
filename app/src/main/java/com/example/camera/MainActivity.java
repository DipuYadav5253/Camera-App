package com.example.camera;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button tnCamera;
     ImageView image;
    int REQUEST_CODE=55;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tnCamera= (Button)findViewById(R.id.tnCamera);
        image= (ImageView) findViewById(R.id.image1);

        tnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(icamera,REQUEST_CODE);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK)
        {
            Bitmap picture= (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(picture);
        }
        else {
            Toast.makeText(this, "Cannot take Images", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}