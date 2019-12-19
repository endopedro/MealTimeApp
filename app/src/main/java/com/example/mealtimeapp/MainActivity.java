package com.example.mealtimeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    SwipeRefreshLayout swipeRefreshLayout;
    MealsAdapter mealsAdapter;
    MealList meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.mealsGrid);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        meals = new MealList();

        try {
            meals = Request.getRandMeal();
        } catch (ExecutionException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        mealsAdapter = new MealsAdapter(this,meals.getMeals());
        gridView.setAdapter(mealsAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(view.getContext(),MealDetailsActivity.class);
                i.putExtra("meal",(Meal)gridView.getAdapter().getItem(position));
                startActivity(i);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateMeals();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    private void updateMeals() {
        try {
            meals = Request.getRandMeal();
        } catch (ExecutionException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        mealsAdapter.setMeals(meals.getMeals());
        swipeRefreshLayout.setRefreshing(false);
    }

}
