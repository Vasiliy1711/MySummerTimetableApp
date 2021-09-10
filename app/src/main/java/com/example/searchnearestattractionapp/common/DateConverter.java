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


    public static String getTimeFromJSON(String base)
    {
        Pattern pTime = Pattern.compile("T(.*?)03:");
        Matcher mTime = pTime.matcher(base);
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

    public static String getDayFromJSON(String base)
    {
        Pattern pDay = Pattern.compile(DateConverter.getMonthFromJSON(base) + "-(.*?)T");
        Matcher mDay = pDay.matcher(base);
        while (mDay.find())
        {
            day = mDay.group(1);
        }
        return day;
    }

    public static String getMonthFromJSON(String base)
    {
        Pattern pMonth = Pattern.compile("-(.*?)-");
        Matcher mMonth = pMonth.matcher(base);
        while (mMonth.find())
        {
            month = mMonth.group(1);
        }
        return month;
    }

    public static String getYearFromJSON(String base)
    {
        Pattern pYear = Pattern.compile("(.*?)-" + DateConverter.getMonthFromJSON(base));
        Matcher mYear = pYear.matcher(base);
        while (mYear.find())
        {
            year = mYear.group(1);
        }
        return year;
    }

    public static String getDateFromJSON(String base)
    {
        int month = Integer.parseInt(DateConverter.getMonthFromJSON(base));
        String day = DateConverter.getDayFromJSON(base);
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

    public static String intToString(int[] date)
    {
        switch (date[1])
        {
            case 1:
              month = "января";
              break;
            case 2:
                month = "февраля";
                break;
            case 3:
                month = "марта";
                break;
            case 4:
                month = "апреля";
                break;
            case 5:
                month = "мая";
                break;
            case 6:
                month = "июня";
                break;
            case 7:
                month = "июля";
                break;
            case 8:
                month = "августа";
                break;
            case 9:
                month = "сентября";
                break;
            case 10:
                month = "октября";
                break;
            case 11:
                month = "ноября";
                break;
            case 12:
                month = "декабря";
                break;
            default:
                month = "";
        }
        return date[2] + " " + month + " " + date[0];
    }

    public static String stringFromInt(int[] iDate)
    {
        return date = iDate[0] + "-" + iDate[1] + "-" + iDate[2];
    }


}