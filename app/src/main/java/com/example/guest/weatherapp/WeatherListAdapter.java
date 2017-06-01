package com.example.guest.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/31/17.
 */

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder> {
    private ArrayList<Weather> mWeathers = new ArrayList<>();
    private Context mContext;

    public WeatherListAdapter(Context context, ArrayList<Weather> weathers){
        mContext = context;
        mWeathers = weathers;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeathers.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.cityTextView) TextView mCity;
        @Bind(R.id.descriptionTextView) TextView mDescription;
        @Bind(R.id.tempTextView) TextView mTemp;
        @Bind(R.id.highLowTextView) TextView mHighLow;
        @Bind(R.id.mainTextView) TextView mMain;

        private  Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindWeather(Weather weather){
            mCity.setText(weather.getCity());
            mDescription.setText(weather.getDescription());
            mTemp.setText(weather.getTemperature().toString() + " F");
            mHighLow.setText("high: " + weather.getMax().toString() + " F / low: " + weather.getMin().toString() +" F");
            mMain.setText(weather.getMain());
        }
    }
}
