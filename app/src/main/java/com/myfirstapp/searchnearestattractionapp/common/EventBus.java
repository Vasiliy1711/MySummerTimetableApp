package com.myfirstapp.searchnearestattractionapp.common;

import com.myfirstapp.searchnearestattractionapp.data.MyRequest;

import io.reactivex.subjects.BehaviorSubject;

public class EventBus
{
    public EventBus()
    {
    }

    public static BehaviorSubject<MyRequest> request = BehaviorSubject.create();
}
