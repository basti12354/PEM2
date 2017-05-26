package com.basti12354.pem2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Basti on 14.05.2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] countryNames;
    LocationObject[]  locationObjects;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, LocationObject[]  locationObjects) {
        this.context = applicationContext;

        this.locationObjects = locationObjects;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return locationObjects.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_layout, null);
        TextView names = (TextView) view.findViewById(R.id.textView);
        names.setText(locationObjects[i].getCityName());
        return view;
    }
}
