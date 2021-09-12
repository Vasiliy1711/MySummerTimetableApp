package com.myfirstapp.searchnearestattractionapp.data;

public class MyRequest
{
    private int[] date;
    private String[] departureInfo;
    private String[] arrivalInfo;
    private String transport_type;

    public MyRequest(int[] date, String[] departureInfo, String[] arrivalInfo, String transport_type)
    {

        this.date = date;
        this.departureInfo = departureInfo;
        this.arrivalInfo = arrivalInfo;
        this.transport_type = transport_type;
    }

    public int[] getDate()
    {
        return date;
    }

    public void setDate(int[] date)
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
