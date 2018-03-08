package com.example.aishwarya.quakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public final class QueryUtils {
    private QueryUtils() {
    }

    public static ArrayList<Quake> extractEarthquakes(String reqUrl) {
        String JSONResponse = makeHTTPRequest(reqUrl);
        ArrayList<Quake> earthquakes = new ArrayList<>();

        try {
            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            JSONObject root = new JSONObject(JSONResponse);
            JSONArray features = root.getJSONArray("features");
            for(int i = 0; i < features.length(); i++){
                JSONObject cur = features.getJSONObject(i);
                JSONObject properties = cur.getJSONObject("properties");
                String mag = properties.getString("mag");
                String place = properties.getString("place");
                long time = properties.getLong("time");
                String url = properties.getString("url");
                earthquakes.add(new Quake(mag, place, time, url));

            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return earthquakes;

    }

    private static String makeHTTPRequest(String reqURL){
        String response = null;
        try{
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;

    }

    private static String convertStreamToString(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try{
            while((line = reader.readLine()) != null){
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }


}