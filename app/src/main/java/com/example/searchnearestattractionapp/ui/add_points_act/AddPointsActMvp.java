package com.example.searchnearestattractionapp.ui.add_points_act;

import com.example.searchnearestattractionapp.common.base_act.BaseActMvp;

import java.util.Calendar;
import java.util.Date;

public interface AddPointsActMvp
{
    interface MvpView extends BaseActMvp<Presenter>
    {
        int getTransportType();

        int getStationDeparture();
        int getStationArrival();
        Calendar getDate();
    }

    interface Presenter
    {
        void btnAddDayClicked();
    }
}
