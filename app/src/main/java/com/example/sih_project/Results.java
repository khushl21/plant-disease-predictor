package com.example.sih_project;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);

        ImageView imageView = findViewById(R.id.imageView2);

        String type = getIntent().getStringExtra("Type");
        if (Objects.equals(type, "Camera")) {
            Bitmap bitmap = getIntent().getParcelableExtra("BitmapImage");
            imageView.setImageBitmap(bitmap);
        }
        else if (Objects.equals(type, "Gallery")) {
            Uri image = getIntent().getParcelableExtra("GalleryImage");
            imageView.setImageURI(image);
        }
    }
}