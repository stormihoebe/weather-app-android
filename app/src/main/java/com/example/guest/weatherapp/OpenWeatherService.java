package com.example.guest.weatherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.json.JSONObject;

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

    public Weather processResults(Response response){
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()){
                JSONObject weatherJson = new JSONObject(jsonData);
                String description =
            }
        }
    }
}
