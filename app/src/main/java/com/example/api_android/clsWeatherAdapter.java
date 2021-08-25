package com.example.api_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class clsWeatherAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<WeatherReportModel> weatherList;

    public clsWeatherAdapter(Context context, int layout, List<WeatherReportModel> weatherList) {
        this.context = context;
        this.layout = layout;
        this.weatherList = weatherList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView =inflater.inflate(layout, null);

        ImageView imgHinhLogo =(ImageView) convertView.findViewById(R.id.imageviewHinh);
        TextView tvSoHop = (TextView) convertView.findViewById(R.id.textviewSoHop);
        TextView tvMaHoSo = (TextView) convertView.findViewById(R.id.textviewMaHoSo);
        TextView tvTrichYeu = (TextView) convertView.findViewById(R.id.textviewTrichDan);

        WeatherReportModel weather = weatherList.get(position);
        tvSoHop.setText(weather.getWeather_state_name());
        tvMaHoSo.setText(weather.getWeather_state_abbr());
        tvTrichYeu.setText(weather.getWind_direction_compass());
        return convertView;
    }
}
