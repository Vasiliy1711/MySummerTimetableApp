package com.myfirstapp.searchnearestattractionapp.ui.schedule_act;

import com.myfirstapp.searchnearestattractionapp.common.base_act.BaseActMvp;
import com.myfirstapp.searchnearestattractionapp.data.MyScheduleItem;

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
