// ktlint-disable filename
package com.example.hazardhunt.core.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

/*
* this class has a Fused LocationProvider client which is from the library
* in the gradle which is responsible for getting the users location. it is an android specific
* implemenyation of location client
* */
class SafetyTaskLocationClient(
    private val context: Context,
    private val client: FusedLocationProviderClient,
) : Locationclient {
    /*
    * this function returns a Location Callback into a flow that gets triggered
    * when a new location is fetched.
    * it also helps in modelling a call back with lifecycle to properly start and stop
    * Location Data collection.
    * */
    @SuppressLint("MissingPermission")
    override fun getLocationUpdate(interval: Long): Flow<Location> {
        return callbackFlow {
            if (!context.isLocationPermissionGranted()) {
                throw Locationclient.LocationException("Location Permission is Not Granted")
            }

            val systemLocationService = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGpsEnabled = systemLocationService.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetWorkEnabled = systemLocationService.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (!isGpsEnabled && !isNetWorkEnabled) {
                throw Locationclient.LocationException("Gps is Disabled")
            }

            val request = LocationRequest
                .create()
                .setInterval(interval)
                .setFastestInterval(interval)

            val locatonCallback = object : LocationCallback() {

                /**
                 * this function is called when the fuesedLocationClient Fetches
                 * a new location
                 *
                 * */

                override fun onLocationResult(result: LocationResult) {
                    super.onLocationResult(result)
                    result.locations.lastOrNull()?.let { location ->
                        launch { send(location) }
                    }
                }
            }

            client.requestLocationUpdates(
                request,
                locatonCallback,
                Looper.getMainLooper(),

            )

            awaitClose {
                client.removeLocationUpdates(locatonCallback)
            }
        }
    }
}
