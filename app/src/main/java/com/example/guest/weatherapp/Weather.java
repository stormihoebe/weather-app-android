package com.example.guest.weatherapp;

/**
 * Created by Guest on 5/31/17.
 */

public class Weather {
    private String mDescription;
    private Integer mTemperature;
    private String mMain;
    private Integer mMaxTemp;
    private Integer mMinTemp;
    private String mCityName;

    public Weather(String description, Integer temperature, String main, Integer max, Integer min, String city){
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

    public Integer getTemperature(){
        return mTemperature;
    }

    public String getMain(){
        return mMain;
    }

    public Integer getMax(){
        return mMaxTemp;
    }

    public Integer getMin(){
        return mMinTemp;
    }

    public String getCity() {
        return mCityName;
    }
}
