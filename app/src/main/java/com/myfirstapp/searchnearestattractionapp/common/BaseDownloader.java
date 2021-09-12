package com.myfirstapp.searchnearestattractionapp.common;

import com.myfirstapp.searchnearestattractionapp.api.ApiFactory;
import com.myfirstapp.searchnearestattractionapp.api.ApiService;
import com.myfirstapp.searchnearestattractionapp.pojo.response1.NetworkResponse1;
import com.myfirstapp.searchnearestattractionapp.pojo.response2.NetworkResponse2;
import com.myfirstapp.searchnearestattractionapp.pojo.response3.NetworkResponse3;
import com.myfirstapp.searchnearestattractionapp.pojo.response4.NetworkResponse4;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BaseDownloader
{
    private static ApiFactory apiFactory = ApiFactory.getInstance();
    private static ApiService apiService = apiFactory.getApiService();

    public static void getScheduleFromNetwork(CompositeDisposable compositeDisposable, String from,
                                              String to, String transport_types, String date,
                                              final Callback<NetworkResponse1> callBack)
    {
        Disposable disposable = apiService.getScheduleFromNetwork(Constants.API_KEY
                , from
                , to
                , transport_types
                , date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NetworkResponse1>()
                {
                    @Override
                    public void accept(NetworkResponse1 response) throws Exception
                    {
                        if (response != null)
                        {
                            callBack.onSuccess(response);
                        }
                    }
                }, new Consumer<Throwable>()
                {
                    @Override
                    public void accept(Throwable throwable) throws Exception
                    {
                        throwable.printStackTrace();
                        callBack.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }

    public static void getScheduleByStation(CompositeDisposable compositeDisposable, String station,
                                            String transport_type, String direction,
                                            final Callback<NetworkResponse2> callback)
    {
        Disposable disposable = apiService.getScheduleByStation(Constants.API_KEY
                , station
                , transport_type
                , direction)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NetworkResponse2>()
                {
                    @Override
                    public void accept(NetworkResponse2 response) throws Exception
                    {
                        callback.onSuccess(response);
                    }
                }, new Consumer<Throwable>()
                {
                    @Override
                    public void accept(Throwable throwable) throws Exception
                    {
                        throwable.printStackTrace();
                        callback.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }

    public static void getStationsByThread(CompositeDisposable compositeDisposable, String uid,
                                           String from, String to, String date,
                                           final Callback<NetworkResponse3> callback)
    {
        Disposable disposable = apiService.getStationsByThread(Constants.API_KEY
                , uid
                , from
                , to
                , date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NetworkResponse3>()
                {
                    @Override
                    public void accept(NetworkResponse3 response) throws Exception
                    {
                        callback.onSuccess(response);
                    }
                }, new Consumer<Throwable>()
                {
                    @Override
                    public void accept(Throwable throwable) throws Exception
                    {
                        throwable.printStackTrace();
                        callback.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }
    public static void getNearestStations(CompositeDisposable compositeDisposable,
                                          String lat, String lng, String distance,
                                          String transport_types, final Callback<NetworkResponse4> callback)
    {
        Disposable disposable = apiService.getNearestStations(Constants.API_KEY
                , lat
                , lng
                , distance
                ,transport_types)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NetworkResponse4>()
                {
                    @Override
                    public void accept(NetworkResponse4 response) throws Exception
                    {
                        callback.onSuccess(response);
                    }
                }, new Consumer<Throwable>()
                {
                    @Override
                    public void accept(Throwable throwable) throws Exception
                    {
                        throwable.printStackTrace();
                        callback.onError();
                    }
                });
        compositeDisposable.add(disposable);
    }
}
