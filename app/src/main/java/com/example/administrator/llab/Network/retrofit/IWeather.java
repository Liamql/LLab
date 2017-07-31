package com.example.administrator.llab.Network.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public interface IWeather {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("/v3/weather/now.json")
    Call<City> getCity(@Query("key")String key,@Query("location")String location);

    @GET("/v3/location/search.json")
    Call<City> weather(@Query("key")String key,@Query("q")String location);
}
