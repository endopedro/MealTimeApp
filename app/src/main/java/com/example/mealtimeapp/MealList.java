package com.example.mealtimeapp;

import java.util.List;

public class MealList {
    private List<Meal> meals;


    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Meal getFirst(){
        return meals.get(0);
    }
}
