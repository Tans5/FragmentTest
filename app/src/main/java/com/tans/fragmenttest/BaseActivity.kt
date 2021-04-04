package com.tans.fragmenttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val activityName: String) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("$activityName: onCreate")
    }


    override fun onStart() {
        super.onStart()
        println("$activityName: onStart")
    }

    override fun onResume() {
        super.onResume()
        println("$activityName: onResume")
    }

    override fun onPause() {
        super.onPause()
        println("$activityName: onPause")
    }

    override fun onStop() {
        super.onStop()
        println("$activityName: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$activityName: onDestroy")
    }
}