package com.example.guest.weatherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class OpenWeatherService {

    public static void getWeather(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

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
}
