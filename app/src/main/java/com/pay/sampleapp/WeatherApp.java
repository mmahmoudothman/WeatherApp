package com.pay.sampleapp;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;


import com.pay.sampleapp.data.DataManager;

import timber.log.Timber;

public class WeatherApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        DataManager.init();
        Timber.plant(new Timber.DebugTree());
    }
}