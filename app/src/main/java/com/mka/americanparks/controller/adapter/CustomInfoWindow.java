package com.mka.americanparks.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.mka.americanparks.R;

public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {

    private Context context;
    private LayoutInflater inflater;
    private View view;

    public CustomInfoWindow(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.view = inflater.inflate(R.layout.custom_info_window, null);
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        return null;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {

        TextView parkName = view.findViewById(R.id.info_title);
        TextView parkState = view.findViewById(R.id.info_state);

        parkName.setText(String.format("Park: %s", marker.getTitle()));
        parkState.setText(String.format("State: %s", marker.getSnippet()));
        return view;
    }
}
