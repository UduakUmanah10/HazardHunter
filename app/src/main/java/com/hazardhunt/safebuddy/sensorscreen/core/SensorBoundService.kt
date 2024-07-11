package com.hazardhunt.safebuddy.sesorsscreen.core

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class SensorBoundService : Service() {

    private val binder = Binder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

/**
     * this is an inner class that provides a method that can be easily used inside
     * the activity. the method returns the bound service that can be used in the activity.
     *
     **/
    inner class MyBinder : Binder() {

        fun getService() = this@SensorBoundService
    }
}
