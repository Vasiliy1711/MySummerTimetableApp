package com.myfirstapp.searchnearestattractionapp.utils;

import java.util.ArrayList;

public class ValidationData
{
    public boolean isValid = true;
    ArrayList<String> errors = new ArrayList<>();

    public void validateDate(int[] date)
    {
        if (date[0] == 0 || date[1] == 0 || date[2] == 0)
        {
            isValid = false;
            errors.add("Пожалуйста, выберите дату!");
        }
    }

    public void validateDepartureInfo(String[] departureInfo)
    {
        if (departureInfo[0] == null || departureInfo[0].isEmpty())
        {
            isValid = false;
            errors.add("Введите пункт отправления!");
        }
    }

    public void validateArrivalInfo(String[] arrivalInfo)
    {
        if (arrivalInfo[0] == null || arrivalInfo[0].isEmpty())
        {
            isValid = false;
            errors.add("Введите пункт назначения!");
        }
    }

    public void validateTransportType(String transport_type)
    {
        if (transport_type == null || transport_type.isEmpty())
        {
            isValid = false;
            errors.add("Выберите вид транспорта!");
        }
    }

    public String getErrorMessage()
    {
        String message = String.join("\n", errors);
        return message;
    }
}
