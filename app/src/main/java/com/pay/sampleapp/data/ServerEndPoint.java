package com.pay.sampleapp.data;



import com.pay.sampleapp.data.Response.WeatherResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

public interface ServerEndPoint {
    @GET("weather")
    Single<WeatherResponse> getCurrentWeather(@Query("q") String city,
                                              @Query("units") String units,
                                              @Query("appid") String appId);

    @GET("weather")
    Single<WeatherResponse> getCurrentWeatherWithLocation(@Query("lat") String lat,
                                                          @Query("lon") String lon,
                                                          @Query("units") String units,
                                                          @Query("appid") String appId);

}