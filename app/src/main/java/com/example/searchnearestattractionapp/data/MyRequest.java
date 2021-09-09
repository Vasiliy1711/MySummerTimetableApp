package com.example.searchnearestattractionapp.data;

import java.util.Date;

public class MyRequest
{
    private String date;
    private String[] departureInfo;
    private String[] arrivalInfo;
    private String transport_type;

    public MyRequest(String date, String[] departureInfo, String[] arrivalInfo, String transport_type)
    {
        this.date = date;
        this.departureInfo = departureInfo;
        this.arrivalInfo = arrivalInfo;
        this.transport_type = transport_type;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String[] getDepartureInfo()
    {
        return departureInfo;
    }

    public void setDepartureInfo(String[] departureInfo)
    {
        this.departureInfo = departureInfo;
    }

    public String[] getArrivalInfo()
    {
        return arrivalInfo;
    }

    public void setArrivalInfo(String[] arrivalInfo)
    {
        this.arrivalInfo = arrivalInfo;
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
