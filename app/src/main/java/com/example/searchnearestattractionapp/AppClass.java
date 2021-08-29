package com.example.searchnearestattractionapp;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class AppClass extends Application
{
    private final String MAPKIT_API_KEY = "d58a2804-a32b-4d6d-800c-a0f26eede847";
    @Override
    public void onCreate()
    {
        super.onCreate();
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}
