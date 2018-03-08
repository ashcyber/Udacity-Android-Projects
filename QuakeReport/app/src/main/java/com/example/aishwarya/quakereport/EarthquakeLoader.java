package com.example.aishwarya.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Aishwarya on 12/18/2016.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Quake>> {
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public List<Quake> loadInBackground() {
        if(mUrl == null){
            return null;
        }
        List<Quake> earthquakes = QueryUtils.extractEarthquakes(mUrl);
        return earthquakes;
    }
}