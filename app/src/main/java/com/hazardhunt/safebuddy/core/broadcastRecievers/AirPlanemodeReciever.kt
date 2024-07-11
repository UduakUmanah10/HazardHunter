// ktlint-disable filename
package com.hazardhunt.safebuddy.core.broadcastRecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class AirPlaneModeReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isTurnedOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON,
            ) != 0

            val message = if (isTurnedOn)"wifi is turned off" else "wifi is turned on"
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}
