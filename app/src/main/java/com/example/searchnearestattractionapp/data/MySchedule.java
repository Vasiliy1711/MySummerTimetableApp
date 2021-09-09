package com.example.searchnearestattractionapp.data;

import java.util.Date;
import java.util.List;

public class MySchedule
{
    private Date date;
    private String weekDay;
    private List<MyScheduleItem> items;

    public MySchedule(Date date, String weekDay, List<MyScheduleItem> items)
    {
        this.date = date;
        this.weekDay = weekDay;
        this.items = items;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getWeekDay()
    {
        return weekDay;
    }

    public void setWeekDay(String weekDay)
    {
        this.weekDay = weekDay;
    }

    public List<MyScheduleItem> getItems()
    {
        return items;
    }

    public void setItems(List<MyScheduleItem> items)
    {
        this.items = items;
    }
}
