package my.edu.tarc.jxel

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class thermo : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var temp: Sensor? = null
    private lateinit var textViewTemp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thermo)

        textViewTemp = findViewById(R.id.tempread)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        temp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)

        val buttonSaveData: Button = findViewById(R.id.button2)
        buttonSaveData.setOnClickListener {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("temperature")

            myRef.setValue(textViewTemp.text.toString())
        }
    }
    override fun onSensorChanged(p0: SensorEvent) {
        val tempData = p0.values[0]
        textViewTemp.text = tempData.toString()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, temp, SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}