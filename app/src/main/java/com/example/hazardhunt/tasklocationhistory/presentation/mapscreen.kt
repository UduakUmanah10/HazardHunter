// ktlint-disable filename
package com.example.hazardhunt.tasklocationhistory.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hazardhunt.ui.theme.HazardHuntTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun MapScreen(
    viewModel: MapViewModel = hiltViewModel(),
    secondViewmodel: MapViewModel = hiltViewModel(),

) {
    val new = secondViewmodel.previousworklocation.collectAsState()
    // val scaffoldState = rememberScaffoldState()
    val uiSettings = remember { MapUiSettings(zoomControlsEnabled = false) }
    Scaffold(
        // scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(MapScreenEvent.ToggleFalloutMap)
            }) {
                Icon(
                    imageVector = if (secondViewmodel.state.isFalloutMap) {
                        Icons.Default.ToggleOff
                    } else { Icons.Default.ToggleOn
                    },
                    contentDescription = "Toggle Fab",
                )
            }
        },

    ) { padding ->
        GoogleMap(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            // properties = viewModel.state.properties,
            properties = new.value.properties,

            uiSettings = uiSettings,
            onMapLongClick = {
                viewModel.onEvent(MapScreenEvent.onMapLongClick(it))
            }, // gives us lat and longitude that would be sent to the vm and saved to database

        ) {
            new.value.previousWorkSpot.forEach { individualposition ->

                Marker(
                    state = rememberMarkerState(
                        position = LatLng(
                            individualposition.latitude,
                            individualposition.longitude,
                        ),
                    ),

                    title = "(${ individualposition.latitude}, ${individualposition.longitude})",
                    snippet = "Long Click To Delete",
                    onInfoWindowLongClick = {
                        viewModel.onEvent(MapScreenEvent.onInfoWindowLongClick(individualposition))
                                            },
                    onClick = {
                        it.showInfoWindow()
                        true
                    },

                )
            }

            //    viewModel.state.previousWorkSpot.forEach { individualposition ->
            //      Marker(
            //        state = rememberMarkerState(
            //          position = LatLng(
            //            individualposition.latitude,
            //          individualposition.longitude,
            //    ),
            // ),
            // icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED),
            // title = " Previous Location(${ individualposition.latitude}, ${individualposition.longitude})",
            // snippet = "Long Click To Delete",
            // onInfoWindowLongClick = { viewModel.onEvent(MapScreenEvent.onInfoWindowLongClick(individualposition)) },
            // onClick = {
            //  it.showInfoWindow()
            // true
            // },

            // )
            // }
        }
    }
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun Mapscreen() {
    HazardHuntTheme {
        Mapscreen()
    }
}
