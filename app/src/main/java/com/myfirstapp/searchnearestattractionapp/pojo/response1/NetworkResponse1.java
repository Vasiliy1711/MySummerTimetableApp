package com.myfirstapp.searchnearestattractionapp.pojo.response1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NetworkResponse1
{
    @SerializedName("segments")
    @Expose
    private List<ScheduleItem1> schedule;

    public NetworkResponse1(List<ScheduleItem1> schedule)
    {
        this.schedule = schedule;
    }

    public List<ScheduleItem1> getSchedule()
    {
        return schedule;
    }

    public void setSchedule(List<ScheduleItem1> schedule)
    {
        this.schedule = schedule;
    }
}
