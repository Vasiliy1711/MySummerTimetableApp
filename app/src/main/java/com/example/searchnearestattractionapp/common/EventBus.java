package com.example.searchnearestattractionapp.common;

import com.example.searchnearestattractionapp.data.MyRequest;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;

public class EventBus
{
    public EventBus()
    {
    }

    public static BehaviorSubject<MyRequest> request = BehaviorSubject.create();
}
