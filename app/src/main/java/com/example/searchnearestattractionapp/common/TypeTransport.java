package com.example.searchnearestattractionapp.common;

public enum TypeTransport
{
    Select("Выберите вид транспорта"),
    Bus("автобус"),
    Suburban("электричка"),
    Train("поезд"),
    Plane("самолет");

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
}
