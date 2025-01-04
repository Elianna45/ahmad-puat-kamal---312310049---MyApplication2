package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class home1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        // Set up click listeners for gambar sections
        findViewById(R.id.gambar01).setOnClickListener(view ->
                startActivity(new Intent(home1.this, gambar3.class)));

        findViewById(R.id.gambar02).setOnClickListener(view ->
                startActivity(new Intent(home1.this, gambar02.class)));

        findViewById(R.id.gambar03).setOnClickListener(view ->
                startActivity(new Intent(home1.this, gambar03.class)));

        findViewById(R.id.gambar1).setOnClickListener(view ->
                startActivity(new Intent(home1.this, gambar1.class)));

        findViewById(R.id.gambar2).setOnClickListener(view ->
                startActivity(new Intent(home1.this, gambar2.class)));

        findViewById(R.id.gambar3).setOnClickListener(view ->
                startActivity(new Intent(home1.this, gambar3.class)));

        // Set up click listeners for bottom toolbar buttons
        findViewById(R.id.search).setOnClickListener(view ->
                startActivity(new Intent(home1.this, search.class)));

        findViewById(R.id.favorit).setOnClickListener(view ->
                startActivity(new Intent(home1.this, favorit.class)));
    }
}
