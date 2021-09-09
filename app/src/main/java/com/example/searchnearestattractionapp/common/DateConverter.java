package com.example.searchnearestattractionapp.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateConverter
{

    private static String date;
    private static String day;
    private static String month;
    private static String year;
    private static String time;


    public static String getTime(String base)
    {
        Pattern pTime = Pattern.compile("T(.*?)03:");
        Matcher mTime = pTime.matcher(base);             //  "2021-09-08T07:05:00+03:00"
        while (mTime.find())
        {
            String fTime = mTime.group(1);
            if (fTime.length() < 5)
            {
                time = fTime.substring(0, 3) + ":03";
            } else
            {
                time = fTime.substring(0, 5);
            }

        }
        return time;
    }

    public static String getDay(String base)
    {
        Pattern pDay = Pattern.compile(DateConverter.getMonth(base) + "-(.*?)T");
        Matcher mDay = pDay.matcher(base);
        while (mDay.find())
        {
            day = mDay.group(1);
        }
        return day;
    }

    public static String getMonth(String base)
    {
        Pattern pMonth = Pattern.compile("-(.*?)-");
        Matcher mMonth = pMonth.matcher(base);
        while (mMonth.find())
        {
            month = mMonth.group(1);
        }
        return month;        //  "2021-09-08T07:05:00+03:00"
    }

    public static String getYear(String base)
    {
        Pattern pYear = Pattern.compile("(.*?)-" + DateConverter.getMonth(base));
        Matcher mYear = pYear.matcher(base);
        while (mYear.find())
        {
            year = mYear.group(1);
        }
        return year;
    }

    public static String getDate(String base)
    {
        int month = Integer.parseInt(DateConverter.getMonth(base));
        String day = DateConverter.getDay(base);
        String sMonth = "янв.";
        if (month != 0)
        {
            switch (month)
            {
                case 1:
                    sMonth = "янв.";
                    break;
                case 2:
                    sMonth = "фев.";
                    break;
                case 3:
                    sMonth = "марта";
                    break;
                case 4:
                    sMonth = "апр.";
                    break;
                case 5:
                    sMonth = "мая.";
                    break;
                case 6:
                    sMonth = "июня";
                    break;
                case 7:
                    sMonth = "июля";
                    break;
                case 8:
                    sMonth = "авг.";
                    break;
                case 9:
                    sMonth = "сент.";
                    break;
                case 10:
                    sMonth = "окт.";
                    break;
                case 11:
                    sMonth = "нояб.";
                    break;
                case 12:
                    sMonth = "дек.";
                    break;
            }
        }

        date = day + " " + sMonth;
        return date;
    }


}


//  https://api.rasp.yandex.net/v3.0/stations_list/?apikey=2babce63-0047-4b6c-9691-1233e12c29f6&lang=ru_RU&format=json&transport_types=suburban