package com.basti12354.pem2;

/**
 * Created by Basti on 13.05.2017.
 */

public class LocationObject {
    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getCityName() {
        return cityName;
    }

    private double latitude;
    private String cityName;

    public LocationObject(double latitude, double longitude, String cityName){
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityName = cityName;
    }
}
