package com.example.sih_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Plant_Info extends AppCompatActivity {

    private static final int pic_id = 123;
    private static final int gallery_id = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_plant_info);

        TextView heading = findViewById(R.id.textView3);
        TextView info = findViewById(R.id.textView4);
        ImageView imageView = findViewById(R.id.imageView);

        Button captureImage = findViewById(R.id.button2);
        Button galleryImage = findViewById(R.id.button3);

        captureImage.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, pic_id);
        });

        galleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });


        String name = getIntent().getStringExtra("Name");
        switch (name){
            case "Onion":
                heading.setText("Onion");
                info.setText("Onions are a cold-season crop, easy to grow because of their hardiness. Plant sets (small onions) in early spring, and you can harvest them in early summer. Plant seeds in late winter, and you can harvest onions in the fall. Either way, onions are a great crop for your vegetable garden.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Lettuce":
                heading.setText("Lettuce");
                info.setText("Lettuce is a great crop for beginners because it grows quickly and doesn’t require a lot of space. Lettuce is a cool-season crop, so you can plant it in early spring or fall. You can also plant lettuce in the summer if you provide some shade and keep the soil moist.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Apple":
                heading.setText("Apple");
                info.setText("Apple trees are the most common fruit trees home gardeners choose to grow. Apples are an excellent source of vitamin C, and dietary fiber. They contain no cholesterol or saturated fats. The apple tree is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Garlic":
                heading.setText("Garlic");
                info.setText("Garlic is a cool-season crop that is planted in the fall in most regions, and in the spring in cold-winter regions. It requires a long growing season of nine months or more. Garlic is easy to grow and requires very little space in the garden.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Carrot":
                heading.setText("Carrot");
                info.setText("Carrots are a popular root vegetable that are easy to grow in sandy soil. They are resistant to most pests and diseases, and are a good late season crop that can tolerate frost. Carrots are a popular vegetable for home gardeners because they have a long storage life and can be used in many ways in the kitchen.");
                imageView.setImageResource(R.drawable.carrot);
                break;
            case "Spinach":
                heading.setText("Spinach");
                info.setText("Spinach is a cool-season crop that is best grown in the spring and fall. It is easy to grow and matures quickly. Spinach is a good source of vitamins A and C, and a good source of iron and calcium. It is also a good source of antioxidants.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Potato":
                heading.setText("Potato");
                info.setText("Potatoes are a cool-season crop that is easy to grow in most regions. They are a good source of vitamin C, and a good source of potassium. Potatoes are a good source of dietary fiber, and are low in calories. They are a good source of antioxidants.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Tomato":
                heading.setText("Tomato");
                info.setText("Tomatoes are a warm-season crop that is easy to grow in most regions. They are a good source of vitamin C, and a good source of vitamin A. Tomatoes are a good source of dietary fiber, and are low in calories. They are a good source of antioxidants.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Mango":
                heading.setText("Mango");
                info.setText("Mangoes are a tropical fruit that is easy to grow in most regions. They are a good source of vitamin C, and a good source of vitamin A. Mangoes are a good source of dietary fiber, and are low in calories. They are a good source of antioxidants.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Strawberry":
                heading.setText("Strawberry");
                info.setText("Strawberries are a cool-season crop that is easy to grow in most regions. They are a good source of vitamin C, and a good source of vitamin A. Strawberries are a good source of dietary fiber, and are low in calories. They are a good source of antioxidants.");
                imageView.setImageResource(R.drawable.tomato);
                break;
            case "Peach":
                heading.setText("Peach");
                info.setText("Peaches are a warm-season crop that is easy to grow in most regions. They are a good source of vitamin C, and a good source of vitamin A. Peaches are a good source of dietary fiber, and are low in calories. They are a good source of antioxidants.");
                imageView.setImageResource(R.drawable.tomato);
                break;
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            if (resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Intent intent = new Intent(this, Results.class);
                intent.putExtra("BitmapImage", photo);
                intent.putExtra("Type", "Camera");
                startActivity(intent);
            }
        }
        else if (requestCode == gallery_id) {
            if (resultCode == RESULT_OK) {
                Uri selectedImage = data.getData();
                Intent intent = new Intent(this, Results.class);
                intent.putExtra("GalleryImage", selectedImage);
                intent.putExtra("Type", "Gallery");
                startActivity(intent);
            }
        }
    }

    protected void imageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), gallery_id);
    }
}