package com.example.searchnearestattractionapp.pojo.response1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationType
{
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("title")
    @Expose
    private String title;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
