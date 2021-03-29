package com.pay.sampleapp.data;


import com.google.gson.GsonBuilder;
import com.pay.sampleapp.data.Response.WeatherResponse;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Single;
import timber.log.Timber;

public class ServerWebAPI {
    private ServerEndPoint serverEndPoint;

    public ServerWebAPI() {
        createApiConnection();
    }

    public void createApiConnection() {
        serverEndPoint = new Retrofit.Builder()
                .baseUrl(Constants.Server_BASE_URL)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient()
                        .create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(ServerEndPoint.class);
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(40, TimeUnit.SECONDS);
        builder.callTimeout(40, TimeUnit.SECONDS);
        builder.readTimeout(40, TimeUnit.SECONDS);
        builder.writeTimeout(40, TimeUnit.SECONDS);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NotNull String message) {
                Timber.i(message);
            }
        });
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        return builder.build();
    }

    public Single<WeatherResponse> getCurrentWeather(String city, String units, String appid) {
        return serverEndPoint.getCurrentWeather(city, units, appid);
    }

    public Single<WeatherResponse> getCurrentWeatherWithLocation(String lat, String lon, String units, String appid) {
        return serverEndPoint.getCurrentWeatherWithLocation(lat, lon, units, appid);
    }
}