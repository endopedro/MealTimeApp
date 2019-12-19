package com.example.mealtimeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MealsAdapter extends BaseAdapter {

    private Context context;
    private List<Meal> meals;

    public MealsAdapter(Context context, List<Meal> meals){
        this.context = context;
        this.meals = meals;
    }

    public int getCount(){
        return this.meals.size();
    }

    public Meal getItem(int position){
        return meals.get(position);
    }
    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Meal meal = meals.get(position);

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.meal_grid_item,null);
        }
        TextView mealName = convertView.findViewById(R.id.meal_name);
        mealName.setText(meal.getStrMeal());

        ImageView mealThumb = convertView.findViewById(R.id.meal_thumb);
        mealThumb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String url = meal.getStrMealThumb();
        Picasso.get().load(url).into(mealThumb);


        return convertView;
    }

    public void setMeals(List<Meal> meals){
        this.meals = meals;
        notifyDataSetChanged();
    }
}
