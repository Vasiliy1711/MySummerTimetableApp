package com.example.searchnearestattractionapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.searchnearestattractionapp.R;
import com.example.searchnearestattractionapp.common.BaseDownloader;
import com.example.searchnearestattractionapp.common.Callback;
import com.example.searchnearestattractionapp.common.DateConverter;
import com.example.searchnearestattractionapp.common.base_act.BaseActivity;
import com.example.searchnearestattractionapp.pojo.response1.NetworkResponse1;
import com.example.searchnearestattractionapp.pojo.response2.NetworkResponse2;
import com.example.searchnearestattractionapp.pojo.response3.NetworkResponse3;
import com.example.searchnearestattractionapp.pojo.response4.NetworkResponse4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestActivity extends BaseActivity
{
    private TextView tv_test;
    private String base = "2021-09-08T07:05:99+03:00";
    String date;
    String day;
    String month;
    String time;
    String year;
    String sec;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);
        time = DateConverter.getTime(base);
        day = DateConverter.getDay(base);
        month = DateConverter.getMonth(base);
        year = DateConverter.getYear(base);
        date = DateConverter.getDate(base);
        Log.e("TAG", "onCreate: " + time);
        Log.e("TAG", "onCreate: " + day);
        Log.e("TAG", "onCreate: " + month);
        Log.e("TAG", "onCreate: " + year);
        Log.e("TAG", "onCreate: " + date);

    }


}


//  @mipmap/ic_launcher





//        Pattern patternTime = Pattern.compile("T(.*?):00");   // T(. * ?):00+03:00
//        Matcher matcherTime = patternTime.matcher(base);
//        while (matcherTime.find())
//        {
//            Log.e("TAG1", matcherTime.group(1));
//        }
//        Pattern patternMonth = Pattern.compile("-(.*?)-");
//        Matcher matcherMonth = patternMonth.matcher(base);
//        while (matcherMonth.find())
//        {
//            Log.e("TAG2", matcherMonth.group(1));
//            month = matcherMonth.group(1);
//        }
//        Pattern patternDay = Pattern.compile(month + "-(.*?)T");
//        Matcher matcherDay = patternDay.matcher(base);
//        while (matcherDay.find())
//        {
//            day = matcherDay.group(1);
//            Log.e("TAG3", day);
//            Log.e("TAG4", month);
//        }
