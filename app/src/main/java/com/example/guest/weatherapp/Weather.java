package com.example.guest.weatherapp;

/**
 * Created by Guest on 5/31/17.
 */

public class Weather {
    private String mDescription;
    private Double mTemperature;
    private String mMain;
    private Double mMaxTemp;
    private Double mMinTemp;
    private String mCityName;

    public Weather(String description, Double temperature, String main, Double max, Double min, String city){
        this.mDescription = description;
        this.mTemperature = temperature;
        this.mMain = main;
        this.mMaxTemp = max;
        this.mMinTemp = min;
        this.mCityName = city;
    }

    public String getDescription(){
        return mDescription;
    }

    public Double getTemperature(){
        return mTemperature;
    }

    public String getMain(){
        return mMain;
    }

    public Double getMax(){
        return mMaxTemp;
    }

    public Double getMin(){
        return mMinTemp;
    }

    public String getCity() {
        return mCityName;
    }
}
