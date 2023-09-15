// ktlint-disable filename
package com.example.hazardhunt.tasklocationhistory.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MapsHomeWork
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

typealias Coordinate = Double
const val LATITUDE:Coordinate = 51.508610
const val LONGITUDE:Coordinate =-0.163611

@Composable
fun testscreen(
    viewModel: MapViewModel = hiltViewModel(),
) {
    val new = viewModel.previousworklocation.collectAsState()
    val uiSettings = remember { MapUiSettings(zoomControlsEnabled = false) }
    val hydePark = LatLng(LATITUDE, LONGITUDE)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(hydePark, 10f)
    }

    Box() {
        Surface {
            GoogleMap(
                properties = new.value.properties,
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                uiSettings = uiSettings,
                onMapLongClick = {
                    viewModel.onEvent(MapScreenEvent.onMapLongClick(it))
                },

            ) {
                new.value.previousWorkSpot.forEach { individualposition ->
                    Marker(
                        state = rememberMarkerState(
                            position = LatLng(
                                individualposition.latitude,
                                individualposition.longitude,
                            ),

                        ),

                        title = "(${individualposition.latitude}, ${individualposition.longitude})",
                        snippet = "Long Click To Delete",
                        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED),
                        onInfoWindowLongClick = {
                            viewModel.onEvent(
                                MapScreenEvent.onInfoWindowLongClick(individualposition)
                            )
                                                },
                        onClick = {
                            it.showInfoWindow()
                            true
                        },
                    )
                }
            }
            FloatingActionButton(
                modifier = Modifier.size(100.dp).align(Alignment.TopEnd),
                onClick = {
                    viewModel.onEvent(MapScreenEvent.ToggleFalloutMap)
                },
            ) {
                Icon(
                    imageVector = if (new.value.isFalloutMap) {
                        Icons.Default.Map
                    } else {
                        Icons.Default.MapsHomeWork
                    },

                    contentDescription = "Toggle Fab",
                )
            }
        }
    }
}
