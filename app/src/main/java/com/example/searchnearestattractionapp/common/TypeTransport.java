package com.example.searchnearestattractionapp.common;

import android.util.Log;
import android.widget.Toast;

public enum TypeTransport
{
    Select("Выберите вид транспорта"),
    Bus("Автобус"),
    Suburban("Электричка"),
    Train("Поезд"),
    Plane("Самолет");

    private String title;
    TypeTransport(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public static TypeTransport initFromPos(int position)
    {
        switch (position)
        {
            case 0:
                return Select;
            case 1:
                return Bus;
            case 2:
                return Suburban;
            case 3:
                return Train;
            case 4:
                return Plane;
        }
        throw new RuntimeException("Error invalid position");
    }

    public int getTypePos()
    {
        switch (this)
        {
            case Select:
                return 0;
            case Bus:
                return 1;
            case Suburban:
                return 2;
            case Train:
                return 3;
            case Plane:
                return 4;
        }
        throw new RuntimeException("Error invalid type");
    }
    public static String onTranslate(String enType)
    {
        String rusType;
        switch (enType)
        {
            case "Bus":
                rusType = TypeTransport.Bus.getTitle();
                break;
            case "Suburban":
                rusType = TypeTransport.Suburban.getTitle();
                break;
            case "Train":
                rusType = TypeTransport.Train.getTitle();
                break;
            case "Plane":
                rusType = TypeTransport.Plane.getTitle();
                break;
            default:
                rusType = "";
        }
        return rusType;
    }
}
