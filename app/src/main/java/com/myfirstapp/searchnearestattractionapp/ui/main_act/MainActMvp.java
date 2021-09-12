package com.myfirstapp.searchnearestattractionapp.ui.main_act;

import com.myfirstapp.searchnearestattractionapp.common.base_act.BaseActMvp;

public interface MainActMvp
{
    interface MvpView extends BaseActMvp<Presenter>
    {
        void setDate(String date);
        void setDeparture(String departure);
        void setArrival(String arrival);
        void setTransportType(String transportType);
    }
    interface Presenter
    {
        void lalSearchClicked();
        void btnSearchScheduleClicked();
    }
}
