package com.example.mealtimeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class MealDetailsActivity extends Activity {

    ImageView detail_meal_thumb;
    TextView detail_meal_name,detail_meal_ingred,detail_meal_instruction,detail_meal_cat,detail_meal_ytb_link;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.meal_details);

        Intent intent = getIntent();

        detail_meal_thumb = findViewById(R.id.detail_meal_thumb);
        detail_meal_name = findViewById(R.id.detail_meal_name);
        detail_meal_ingred = findViewById(R.id.detail_meal_ingred);
        detail_meal_instruction = findViewById(R.id.detail_meal_instruction);
        detail_meal_cat = findViewById(R.id.detail_meal_cat);
        detail_meal_ytb_link = findViewById(R.id.detail_meal_ytb_link);

        Meal m = (Meal)intent.getSerializableExtra("meal");

        Picasso.get().load(m.getStrMealThumb()).into(detail_meal_thumb);
        detail_meal_name.setText(m.getStrMeal());
        detail_meal_ingred.setText(m.concatIngredientsMeasures());
        detail_meal_instruction.setText(m.getStrInstructions());
        detail_meal_cat.setText("Category: " + m.getStrCategory());
        detail_meal_ytb_link.setText("Watch on: " + m.getStrYoutube());


    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
