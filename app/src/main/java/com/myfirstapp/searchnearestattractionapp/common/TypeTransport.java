package com.myfirstapp.searchnearestattractionapp.common;

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

    public static String initFromPos(int position)
    {
        switch (position)
        {
            case 0:
                return null;
            case 1:
                return Bus.title;
            case 2:
                return Suburban.title;
            case 3:
                return Train.title;
            case 4:
                return Plane.title;
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
    public static String onTranslate(String inType)
    {
        String outType;
        switch (inType)
        {
            case "Bus":
                outType = Bus.title;
                break;
            case "Suburban":
                outType = TypeTransport.Suburban.getTitle();
                break;
            case "Train":
                outType = TypeTransport.Train.getTitle();
                break;
            case "Plane":
                outType = TypeTransport.Plane.getTitle();
                break;
            case "Автобус":
                outType = "Bus";
                break;
            case "Электричка":
                outType = "Suburban";
                break;
            case "Поезд":
                outType = "Train";
                break;
            case "Самолет":
                outType = "Plane";
                break;
            default:
                outType = "";
        }
        return outType;
    }
}
