package com.example.searchnearestattractionapp.ui.schedule_act;

import com.example.searchnearestattractionapp.common.base_act.BaseActMvp;
import com.example.searchnearestattractionapp.data.MyScheduleItem;

import java.util.List;

public interface ScheduleActMvp
{
    interface MvpView extends BaseActMvp<Presenter>
    {
        void setScheduleItems(List<MyScheduleItem> items);
    }
    interface Presenter
    {
        void btnAdvSearchClicked();
    }
}
