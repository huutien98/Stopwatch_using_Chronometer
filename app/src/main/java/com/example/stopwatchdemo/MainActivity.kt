package com.example.stopwatchdemo

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var stopTime:Long = 0
        // chronometer không thể hiển thị từng giây được vì nó được cập nhật theo giây
        btn_start.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()+stopTime
            chronometer.start()
            btn_start.visibility = View.GONE
            btn_pause.visibility = View.VISIBLE
        }

        btn_pause.setOnClickListener {
            stopTime = chronometer.base - SystemClock.elapsedRealtime()
            chronometer.stop()
            btn_start.visibility = View.VISIBLE
            btn_reset.visibility = View.VISIBLE
            btn_pause.visibility = View.GONE
        }

        btn_reset.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            stopTime = 0
            chronometer.stop()
            btn_pause.visibility = View.GONE
            btn_start.visibility = View.VISIBLE
        }


    }
}