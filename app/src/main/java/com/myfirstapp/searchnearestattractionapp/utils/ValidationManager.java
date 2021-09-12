package com.myfirstapp.searchnearestattractionapp.utils;

public class ValidationManager
{
    public static ValidationData validateDataEntry(int[] date, String[] departureInfo, String[] arrivalInfo, String transportType)
    {
        ValidationData data = new ValidationData();
        data.validateDate(date);
        data.validateDepartureInfo(departureInfo);
        data.validateArrivalInfo(arrivalInfo);
        data.validateTransportType(transportType);
        return data;
    }
}
