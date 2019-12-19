package com.example.mealtimeapp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class Request {


    public static MealList getRandMeal() throws ExecutionException, InterruptedException {
        MealList ml = new MealList();
        List<Meal> meals = new ArrayList<>();
        for(int i=0; i<6; i++){
           ml = new HttpService("random.php").execute().get();
            if(ml!=null){
                meals.add(ml.getFirst());
            }
       }
        ml.setMeals(meals);

        return ml;
    }

    public static Meal getMealDetails(int id) throws ExecutionException, InterruptedException {
        MealList meals = new HttpService("lookup.php?i="+id).execute().get();
        Meal m=null;
        if(meals!=null){
            m = meals.getFirst();
        }
        return m;
    }
}
