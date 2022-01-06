package com.example.zadanie8balyka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private List<Sensor> sensorList;
    RecyclerView recyclerView;
    TextView numberOfSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        numberOfSensors = findViewById(R.id.numberOfSensors);
        numberOfSensors.setText(Integer.toString(sensorList.size()) + " " + getResources().getString(R.string.sensors));

        recyclerView = findViewById(R.id.recyclerView);

        SensorListAdapter sensorListAdapter = new SensorListAdapter(this, sensorList);
        recyclerView.setAdapter(sensorListAdapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
    }
}