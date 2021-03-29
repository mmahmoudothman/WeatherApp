package com.pay.sampleapp.data;


import android.content.Context;

import com.pay.sampleapp.data.Response.WeatherResponse;


import rx.Single;

import static com.pay.sampleapp.data.Constants.KEY;
import static com.pay.sampleapp.data.Constants.UNITS;

public final class DataManager {
    private static ServerWebAPI serverWebAPI;

    private DataManager() {
    }

    public static void init() {
        serverWebAPI = new ServerWebAPI();
    }

    public static Single<WeatherResponse> getCurrentWeather(String city) {
        return serverWebAPI.getCurrentWeather(city, UNITS, KEY);
    }

    public static Single<WeatherResponse> getCurrentWeather(String lat, String lon) {
        return serverWebAPI.getCurrentWeatherWithLocation(lat, lon, UNITS, KEY);
    }
}