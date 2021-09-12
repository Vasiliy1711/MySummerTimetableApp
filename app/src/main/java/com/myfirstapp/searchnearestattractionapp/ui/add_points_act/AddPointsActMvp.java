package com.myfirstapp.searchnearestattractionapp.ui.add_points_act;

import com.myfirstapp.searchnearestattractionapp.common.base_act.BaseActMvp;

public interface AddPointsActMvp
{
    interface MvpView extends BaseActMvp<Presenter>
    {
        int getTransportType();

        int getStationDeparture();
        int getStationArrival();
        int[] getDate();
    }

    interface Presenter
    {
        void btnAddDayClicked();
    }
}
