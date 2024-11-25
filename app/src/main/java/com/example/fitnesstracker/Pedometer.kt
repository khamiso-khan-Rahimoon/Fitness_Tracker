package com.example.fitnesstracker

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Pedometer : AppCompatActivity(), SensorEventListener {
    var sensor: Sensor? = null
    var sensorManager: SensorManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pedometer)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_PRESSURE)




    }


    override fun onResume() {
        super.onResume()
        if (sensor == null){
            Toast.makeText(this, "Sensor Not found", Toast.LENGTH_SHORT).show()
        }else{
            sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }
    override fun onSensorChanged(event: SensorEvent?) {
        val stepsTaken = event!!.values[0]
        val steps = findViewById<TextView>(R.id.textView2)
        steps.text = stepsTaken.toString()

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}