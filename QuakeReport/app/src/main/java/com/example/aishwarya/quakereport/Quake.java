package com.example.aishwarya.quakereport;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Quake {
    private String quake_mag;
    private String quake_place;
    private  long getQuake_timeMillis;
    private String url;

    public Quake(String mag, String place, long timeMillis,String url){
        quake_mag = mag;
        quake_place = place;
        getQuake_timeMillis = timeMillis;
        this.url = url;
    }


    public String getQuake_mag() {
        return quake_mag;
    }
    public String getQuake_place() {
        return quake_place;
    }
    public long getQuake_timeMillis() {
        return getQuake_timeMillis;
    }
    public String getQuake_url(){return url;}

    public String formatMagnitude(){
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(Double.parseDouble(getQuake_mag()));
        return  output;
    }

    public String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    public String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
