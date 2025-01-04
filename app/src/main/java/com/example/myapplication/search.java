package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class search extends AppCompatActivity {

    private EditText searchBar;
    private LinearLayout gambar1, gambar2, gambar3, gambar4, gambar5, gambar6;
    private TextView foodName1, foodName2, foodName3, foodName4, foodName5, foodName6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initialize views
        searchBar = findViewById(R.id.search_bar);
        gambar1 = findViewById(R.id.gambar1);
        gambar2 = findViewById(R.id.gambar2);
        gambar3 = findViewById(R.id.gambar3);
        gambar4 = findViewById(R.id.gambar4);
        gambar5 = findViewById(R.id.gambar5);
        gambar6 = findViewById(R.id.gambar6);

        foodName1 = findViewById(R.id.foodName1);
        foodName2 = findViewById(R.id.foodName2);
        foodName3 = findViewById(R.id.foodName3);
        foodName4 = findViewById(R.id.foodName4);
        foodName5 = findViewById(R.id.foodName5);
        foodName6 = findViewById(R.id.foodName6);

        // Add text change listener to search bar
        searchBar.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterFoods(s.toString());
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {
                // Not used
            }
        });

        // Set click listeners for the food items
        setFoodItemClickListeners();

        // Set click listeners for the bottom toolbar buttons
        setBottomToolbarClickListeners();
    }

    private void filterFoods(String query) {
        // Reset visibility of all food items
        resetVisibility();

        // Check if query matches food names and show/hide accordingly
        if (!foodName1.getText().toString().toLowerCase().contains(query.toLowerCase())) {
            gambar1.setVisibility(View.GONE);
        }
        if (!foodName2.getText().toString().toLowerCase().contains(query.toLowerCase())) {
            gambar2.setVisibility(View.GONE);
        }
        if (!foodName3.getText().toString().toLowerCase().contains(query.toLowerCase())) {
            gambar3.setVisibility(View.GONE);
        }
        if (!foodName4.getText().toString().toLowerCase().contains(query.toLowerCase())) {
            gambar4.setVisibility(View.GONE);
        }
        if (!foodName5.getText().toString().toLowerCase().contains(query.toLowerCase())) {
            gambar5.setVisibility(View.GONE);
        }
        if (!foodName6.getText().toString().toLowerCase().contains(query.toLowerCase())) {
            gambar6.setVisibility(View.GONE);
        }
    }

    private void resetVisibility() {
        gambar1.setVisibility(View.VISIBLE);
        gambar2.setVisibility(View.VISIBLE);
        gambar3.setVisibility(View.VISIBLE);
        gambar4.setVisibility(View.VISIBLE);
        gambar5.setVisibility(View.VISIBLE);
        gambar6.setVisibility(View.VISIBLE);
    }

    private void setFoodItemClickListeners() {
        gambar1.setOnClickListener(view -> openFoodActivity("gambar01"));
        gambar2.setOnClickListener(view -> openFoodActivity("gambar02"));
        gambar3.setOnClickListener(view -> openFoodActivity("gambar03"));
        gambar4.setOnClickListener(view -> openFoodActivity("gambar1"));
        gambar5.setOnClickListener(view -> openFoodActivity("gambar2"));
        gambar6.setOnClickListener(view -> openFoodActivity("gambar3"));
    }

    private void openFoodActivity(String activityName) {
        Intent intent = null;
        switch (activityName) {
            case "gambar01":
                intent = new Intent(search.this, gambar01.class);
                break;
            case "gambar02":
                intent = new Intent(search.this, gambar02.class);
                break;
            case "gambar03":
                intent = new Intent(search.this, gambar03.class);
                break;
            case "gambar1":
                intent = new Intent(search.this, gambar1.class);
                break;
            case "gambar2":
                intent = new Intent(search.this, gambar2.class);
                break;
            case "gambar3":
                intent = new Intent(search.this, gambar3.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    private void setBottomToolbarClickListeners() {
        findViewById(R.id.home).setOnClickListener(view -> openActivity(home1.class));
        findViewById(R.id.favorit).setOnClickListener(view -> openActivity(favorit.class));
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(search.this, activityClass);
        startActivity(intent);
    }
}
