package com.myfirstapp.searchnearestattractionapp.pojo.response1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScheduleItem1
{

    @SerializedName("arrival")
    @Expose
    private String arrival;
    @SerializedName("from")
    @Expose
    private StationType from;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("thread")
    @Expose
    private Thread thread;
    @SerializedName("stops")
    @Expose
    private String stops;
    @SerializedName("to")
    @Expose
    private StationType to;
    @SerializedName("departure")
    @Expose
    private String departure;



    public StationType getFrom()
    {
        return from;
    }

    public void setFrom(StationType from)
    {
        this.from = from;
    }

    public StationType getTo()
    {
        return to;
    }

    public void setTo(StationType to)
    {
        this.to = to;
    }

    public Object getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}
