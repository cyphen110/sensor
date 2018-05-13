package com.example.sensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends Activity implements SensorEventListener {

    private SensorManager SM;
    private Sensor mySensor;
    private TextView x, y, z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);


        // Create Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView
        x = (TextView) findViewById(R.id.currentX);
        y = (TextView) findViewById(R.id.currentY);
        z = (TextView) findViewById(R.id.currentZ);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("X: " + event.values[0]);
        y.setText("Y: " + event.values[1]);
        z.setText("Z: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }
}
