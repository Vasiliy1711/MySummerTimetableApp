package com.myfirstapp.searchnearestattractionapp.api;

import com.myfirstapp.searchnearestattractionapp.pojo.response1.NetworkResponse1;
import com.myfirstapp.searchnearestattractionapp.pojo.response2.NetworkResponse2;
import com.myfirstapp.searchnearestattractionapp.pojo.response3.NetworkResponse3;
import com.myfirstapp.searchnearestattractionapp.pojo.response4.NetworkResponse4;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService
{
    @GET("search/")
    Observable<NetworkResponse1> getScheduleFromNetwork(@Query("apikey") String api_key,
                                                        @Query("from") String from,
                                                        @Query("to") String to,
                                                        @Query("transport_types") String transport_types,
                                                        @Query("date") String date);

    @GET("schedule/")
    Observable<NetworkResponse2> getScheduleByStation(@Query("apikey") String api_key,
                                                      @Query("station") String station,
                                                      @Query("transport_types") String transport_types,
                                                      @Query("direction") String direction);

    @GET("thread/")
    Observable<NetworkResponse3> getStationsByThread(@Query("apikey") String api_key,
                                                     @Query("uid") String uid,
                                                     @Query("from")String from,
                                                     @Query("to")String to,
                                                     @Query("date")String date);

    @GET("nearest_stations/")
    Observable<NetworkResponse4> getNearestStations(@Query("apikey") String api_key,
                                                    @Query("lat") String lat,
                                                    @Query("lng") String lng,
                                                    @Query("distance") String distance,
                                                    @Query("transport_types") String transport_types);
}


// https://api.rasp.yandex.net/v3.0/schedule/?apikey=2babce63-0047-4b6c-9691-1233e12c29f6&station=s9600213&transport_types=suburban&direction=на%20Москву

// https://api.rasp.yandex.net/v3.0/thread/?apikey={ключ}&format=json&uid=038AA_tis&lang=ru_RU&show_systems=all

// https://api.rasp.yandex.net/v3.0/nearest_stations/?apikey=2babce63-0047-4b6c-9691-1233e12c29f6&format=json&lat=55.548339&lng=37.685784&distance=50&transport_types=suburban,plane,bus&lang=ru_RU

//  55.548339, 37.685784

//  https://api.rasp.yandex.net/v3.0/search/?apikey=2babce63-0047-4b6c-9691-1233e12c29f6&format=json&from=s2000005&to=s9601332&lang=ru_RU&page=1&date=2021-05-04


//  https://rasp.yandex.ru/thread/R_6325_2000001_g21_4?departure_from=2021-09-05+19%3A53%3A00&station_from=2000001&utm_campaign=blank&utm_medium=station&utm_source=informer

//  https://rasp.yandex.ru/informers/widgets/search/vert/