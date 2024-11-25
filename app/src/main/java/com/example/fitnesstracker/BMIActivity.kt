package com.example.fitnesstracker

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitnesstracker.databinding.ActivityBmiactivityBinding

class BMIActivity : AppCompatActivity() {
    lateinit var binding: ActivityBmiactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val height = findViewById<EditText>(R.id.heightTE)
        val weight = findViewById<EditText>(R.id.weightTE)
        val resultText = findViewById<TextView>(R.id.resultTV)



        binding.calculateBMIBTN.setOnClickListener {
            val heightInput = height.text.toString().trim()
            val weightInput = weight.text.toString().trim()

            if (heightInput.isEmpty() || weightInput.isEmpty()) {
                Toast.makeText(this, "Fill all above fields", Toast.LENGTH_SHORT).show()
            } else {
                val h = heightInput.toFloat() / 100
                val w = weightInput.toFloat()

                val r = w / (h * h)

                when {
                    r < 18.5 -> {
                        resultText.text = "You are Underweight & BMI: %.2f".format(r)
                    }
                    r in 18.5..24.9 -> {
                        resultText.text = "You are Healthy & BMI: %.2f".format(r)
                    }
                    r in  25.0..29.9 ->{
                        resultText.text = "You are Overweight & BMI: %.2f".format(r)
                    }
                    r in 30.0..39.9 ->{
                        resultText.text = "Obesity & BMI: %.2f".format(r)
                    }
                    else -> {
                        resultText.text = "Severe obesity & BMI: %.2f".format(r)
                    }
                }
            }
        }


        


    }
}