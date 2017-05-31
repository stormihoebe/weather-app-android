package com.example.guest.weatherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class OpenWeatherService {

    public static void findWeather(String location, Callback callback) {


        OkHttpClient client = new OkHttpClient.Builder().build();

        Log.d("Constants Zip", Constants.BASE_URL);
        Log.d("Constants Zip", Constants.PARAM);
        Log.d("Constants Zip", Constants.OPEN_WEATHER_KEY);
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.ZIP, location);
        urlBuilder.addQueryParameter(Constants.PARAM, Constants.OPEN_WEATHER_KEY);
        String url = urlBuilder.build().toString();

        Log.d("url", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Weather> processResults(Response response) {
        ArrayList<Weather> weather = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject weatherJson = new JSONObject(jsonData);
                String description = weatherJson.getJSONArray("weather").getJSONObject(0).getString("description");
                String main = weatherJson.getJSONArray("weather").getJSONObject(0).getString("main");
                double temp = weatherJson.getJSONObject("main").getDouble("temp");
                double min = weatherJson.getJSONObject("main").getDouble("temp_min");
                double max = weatherJson.getJSONObject("main").getDouble("temp_max");
                String city = weatherJson.getString("name");
                Weather instanceOf = new Weather(description, temp, main, max, min, city);
                weather.add(instanceOf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weather;
    }
}
