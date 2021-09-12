package com.myfirstapp.searchnearestattractionapp.common;

public interface Callback<T>
{
    void onSuccess(T response);
    void onError();
}
