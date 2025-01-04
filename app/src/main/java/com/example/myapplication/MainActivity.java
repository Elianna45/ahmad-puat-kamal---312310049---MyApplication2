package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ImageView for the star button
        ImageView starButton = findViewById(R.id.starButton);

        // Set an OnClickListener for the star button
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to HomeActivity
                Intent intent = new Intent(MainActivity.this, home1.class);
                startActivity(intent);  // Start the new activity
            }
        });
    }
}
