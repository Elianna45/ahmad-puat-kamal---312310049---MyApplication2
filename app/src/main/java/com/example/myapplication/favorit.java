package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class favorit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit); // pastikan layout sesuai dengan nama file Anda

        // Tombol Home
        ImageView homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke activity_home1.xml
                Intent intent = new Intent(favorit.this, home1.class);
                startActivity(intent);
            }
        });

        // Tombol Search
        ImageView searchButton = findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke activity_search.xml
                Intent intent = new Intent(favorit.this, search.class);
                startActivity(intent);
            }
        });
    }
}
