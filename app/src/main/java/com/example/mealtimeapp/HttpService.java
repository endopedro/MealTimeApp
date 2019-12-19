package com.example.mealtimeapp;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpService extends AsyncTask<String, Void, MealList> {

    private String reqURL ="";

    public HttpService (String req){
        reqURL = "https://www.themealdb.com/api/json/v1/1/"+req;
    }
    @Override
    protected MealList doInBackground(String... apiRequest) {
        String response ="";
        URL url = null;
        HttpURLConnection connection = null;

            try {
                url = new URL(reqURL);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                InputStream in = new BufferedInputStream(connection.getInputStream());
                response = IOUtils.toString(in,"UTF-8");


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(connection != null) {
                    connection.disconnect();
                }
            }
        return new Gson().fromJson(response, MealList.class);
    }

}
