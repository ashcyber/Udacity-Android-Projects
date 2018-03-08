package com.example.aishwarya.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 * Created by Aishwarya on 12/13/2016.
 */

public class QuakeAdapter extends ArrayAdapter<Quake> {
    private static final String LOCATION_SEPARATOR = " of ";
    private String locationOffset = "";
    private String primaryLocation = "";

    public QuakeAdapter(Context context, List<Quake> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent,false);

        }

        Quake curQuake = getItem(position);
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.quake_magnitude);
        magnitudeTextView.setText(curQuake.formatMagnitude());

        if(curQuake.getQuake_place().contains(LOCATION_SEPARATOR)){
            String[] parts = curQuake.getQuake_place().split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }else{
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = curQuake.getQuake_place();
        }

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.quake_place);
        placeTextView.setText(primaryLocation);

        TextView directionTextView = (TextView) listItemView.findViewById(R.id.quake_direction);
        directionTextView.setText(locationOffset);

        Date dateObject = new Date(curQuake.getQuake_timeMillis());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.quake_date);
        dateTextView.setText(curQuake.formatDate(dateObject));

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.quake_time);
        timeTextView.setText(curQuake.formatTime(dateObject));

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(curQuake.getQuake_mag());
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;

    }


    public int getMagnitudeColor(String mag){
        double doubleMag = Double.parseDouble(mag);
        int intMag = (int) doubleMag;
        int magnitudeColor = -1;
        switch (intMag){
            case 1:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case 10:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);


        }
        return magnitudeColor;
    }
}
