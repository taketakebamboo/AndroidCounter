package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler : Handler =Handler(Looper.getMainLooper())
        val countTxt : TextView = findViewById(R.id.countText)
        val plusBtn : Button = findViewById(R.id.plusButton)
        val minusBtn : Button = findViewById(R.id.minusButton)
        val resetBtn : Button = findViewById(R.id.resetButton)


    }
}