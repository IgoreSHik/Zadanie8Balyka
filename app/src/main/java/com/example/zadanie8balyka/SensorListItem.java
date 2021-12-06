package com.example.zadanie8balyka;

import static android.view.View.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SensorListItem extends Fragment {
    String text;

    @Nullable
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView here = (TextView) view.findViewById(R.id.sensorName);
        here.setText(text);
    }

    public SensorListItem(String text) {
        super(R.layout.sensor_list_item);
        this.text = text;
    }
}