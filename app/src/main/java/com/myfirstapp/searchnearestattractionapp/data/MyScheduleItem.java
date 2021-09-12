package com.myfirstapp.searchnearestattractionapp.data;

public class MyScheduleItem
{
    private String number, threadTitle, departureTime, depStationTitle,  arrivalTime
            , arrStationTitle, stops, duration, transport_type;

    public MyScheduleItem(String number, String threadTitle, String departureTime, String depStationTitle, String arrivalTime, String arrStationTitle, String stops, String duration, String transport_type)
    {
        this.number = number;
        this.threadTitle = threadTitle;
        this.departureTime = departureTime;
        this.depStationTitle = depStationTitle;
        this.arrivalTime = arrivalTime;
        this.arrStationTitle = arrStationTitle;
        this.stops = stops;
        this.duration = duration;
        this.transport_type = transport_type;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getThreadTitle()
    {
        return threadTitle;
    }

    public void setThreadTitle(String threadTitle)
    {
        this.threadTitle = threadTitle;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }

    public String getDepStationTitle()
    {
        return depStationTitle;
    }

    public void setDepStationTitle(String depStationTitle)
    {
        this.depStationTitle = depStationTitle;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public String getArrStationTitle()
    {
        return arrStationTitle;
    }

    public void setArrStationTitle(String arrStationTitle)
    {
        this.arrStationTitle = arrStationTitle;
    }

    public String getStops()
    {
        return stops;
    }

    public void setStops(String stops)
    {
        this.stops = stops;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getTransport_type()
    {
        return transport_type;
    }

    public void setTransport_type(String transport_type)
    {
        this.transport_type = transport_type;
    }
}





