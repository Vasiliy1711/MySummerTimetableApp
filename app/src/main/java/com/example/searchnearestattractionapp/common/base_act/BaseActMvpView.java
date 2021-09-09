package com.example.searchnearestattractionapp.common.base_act;

import android.view.LayoutInflater;
import android.view.View;

public class BaseActMvpView
{
    protected View rootView;
    protected LayoutInflater inflater;

    public BaseActMvpView(LayoutInflater inflater)
    {
        this.inflater = inflater;
    }
}
