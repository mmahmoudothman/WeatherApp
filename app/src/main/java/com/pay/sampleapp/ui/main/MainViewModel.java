package com.pay.sampleapp.ui.main;


import androidx.lifecycle.MutableLiveData;

import com.pay.sampleapp.ui.baseActivity.BaseActivityViewModel;
import com.pay.sampleapp.data.DataManager;
import com.pay.sampleapp.data.Response.WeatherResponse;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainViewModel extends BaseActivityViewModel {
    private MutableLiveData<WeatherResponse> weather = new MutableLiveData<>();

    public MutableLiveData<WeatherResponse> getWeather() {
        return weather;
    }

    public void setWeather(WeatherResponse weather) {
        this.weather.setValue(weather);
    }


    void getWeather(String city) {
        setShowLoadingProgress(true);
        DataManager.getCurrentWeather(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        setFailMessage(throwable.getMessage());
                    }

                    @Override
                    public void onNext(WeatherResponse weatherResponse) {
                        setShowLoadingProgress(false);
                        setWeather(weatherResponse);
                    }
                });
    }

    void getWeather(String lat, String lon) {
        setShowLoadingProgress(true);
        DataManager.getCurrentWeather(lat, lon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        setFailMessage(throwable.getMessage());
                    }

                    @Override
                    public void onNext(WeatherResponse weatherResponse) {
                        setShowLoadingProgress(false);
                        setWeather(weatherResponse);
                    }
                });
    }
}
