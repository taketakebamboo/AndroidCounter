package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity(),Runnable, View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    private val handler: Handler = Handler(Looper.getMainLooper())
    private var count: Int = 0
    private var countFlag: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // plusButton
        val plusBtn: Button = findViewById(R.id.plusButton)
        plusBtn.setOnClickListener(this)
        plusBtn.setOnLongClickListener(this)
        plusBtn.setOnTouchListener(this)

        val minusBtn: Button = findViewById(R.id.minusButton)
        minusBtn.setOnClickListener(this)
        minusBtn.setOnLongClickListener(this)
        minusBtn.setOnTouchListener(this)

        val resetBtn: Button = findViewById(R.id.resetButton)
        resetBtn.setOnClickListener(this)
    }

   override fun onClick(view: View){
        when (view.id) {

            R.id.plusButton -> {
                countPlus()
            }

            R.id.minusButton -> {
                countMinus()
            }

            R.id.resetButton -> {
                countReset()
            }
        }
   }

    override fun onLongClick(view: View) : Boolean {
        when (view.id) {

            R.id.plusButton -> {
                countPlus()
                handler.postDelayed(this,100)
            }

            R.id.minusButton -> {
                countMinus()
                handler.postDelayed(this,100)
            }
        }
        return(true)
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        when (view.id) {

            R.id.plusButton -> {
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        // 押された時は何もしない
                    }
                    MotionEvent.ACTION_UP -> {
                        handler.removeCallbacks(this)
                    }
                }
            }

            R.id.minusButton -> {
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        // 押された時は何もしない
                    }
                    MotionEvent.ACTION_UP -> {
                        handler.removeCallbacks(this)
                    }
                }
            }
        }
        return(false)
    }

    override fun run() {
        when (countFlag) {
            1 -> {
                countPlus()
            }
            0 -> {
                countMinus()
            }
        }
        handler.postDelayed(this,100)
    }

    private fun countPlus() {
        count++

        val countTxt: TextView = findViewById(R.id.countText)
        countTxt.text = "$count"
        countTxt.textSize = 30f
        countFlag = 1
    }

    private fun countMinus() {
        if (count > 0) {
            count--
            val countTxt: TextView = findViewById(R.id.countText)
            countTxt.text = "$count"
            countTxt.textSize = 30f
            countFlag = 0
        }
    }

    private fun countReset() {
        count = 0
        val countTxt: TextView = findViewById(R.id.countText)
        countTxt.text = getString(R.string.initcounttext)
        countTxt.textSize = 14f
    }

}