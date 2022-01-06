package com.example.zadanie8balyka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SensorDetailsActivity extends AppCompatActivity implements SensorEventListener{

    TextView nazwa, dane;
    String name;
    String type;
    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_details);

        nazwa = findViewById(R.id.sensorDetailsName);
        dane = findViewById(R.id.sensorDetailsDesc);

        getData();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Integer.parseInt(type));

        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("Nazwa") && getIntent().hasExtra("Typ"))
        {
            name = getIntent().getStringExtra("Nazwa");
            type = getIntent().getStringExtra("Typ");
        }
    }

    private void setData() {
        nazwa.setText(type);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        String text = "";
        for (int i = 0; i < event.values.length; i++)
        {
            text += Float.toString(event.values[0]) + ";\n";
        }
        dane.setText(text);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}