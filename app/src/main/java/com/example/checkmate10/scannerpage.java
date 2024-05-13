package com.example.checkmate10;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class scanner_page extends AppCompatActivity {
    private static final int REQUEST_CODE = 22;
    Button btnpicture;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_page); // assuming your layout file is named scanner_page.xml

        btnpicture = findViewById(R.id.button);
        imageView = findViewById(R.id.videoView2);

        btnpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap photo = (Bitmap) extras.get("data");
                    imageView.setImageBitmap(photo);
                }
            }
        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        }
    }
}
