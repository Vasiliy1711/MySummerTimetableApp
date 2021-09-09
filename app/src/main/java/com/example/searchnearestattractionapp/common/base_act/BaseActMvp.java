package com.example.searchnearestattractionapp.common.base_act;

import android.view.View;

public interface BaseActMvp<PresenterType>
{
    View getRootView();
    void registerPresenter(PresenterType presenter);
}
