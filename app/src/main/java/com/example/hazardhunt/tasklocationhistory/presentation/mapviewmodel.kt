// ktlint-disable filename
package com.example.hazardhunt.tasklocationhistory.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hazardhunt.tasklocationhistory.domain.model.PreviousWorkLocation
import com.example.hazardhunt.tasklocationhistory.domain.repository.PreviousWorkLocationRepository
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val repository: PreviousWorkLocationRepository,
) : ViewModel() {
    init {

        viewModelScope.launch {
            repository.getAllPreviousLocation().collectLatest { spots ->
                state = state.copy(
                    previousWorkSpot = spots,

                )
                mstate.value = Mapscreenstate(
                    previousWorkSpot = spots,
                )
            }
        }
    }

    fun changeMapview() {
        val toggle = !mstate.value.isFalloutMap
        val previousspot = mstate.value.previousWorkSpot
        val properties = mstate.value.properties

        mstate.value = Mapscreenstate(
            previousWorkSpot = previousspot,
            isFalloutMap = toggle,
            properties = properties,
        )
    }

    private var mstate: MutableStateFlow<Mapscreenstate> = MutableStateFlow(Mapscreenstate())

    var state by mutableStateOf(Mapscreenstate())
    var previousworklocation: StateFlow<Mapscreenstate> = mstate

    fun onEvent(event: MapScreenEvent) {
        when (event) {
            MapScreenEvent.ToggleFalloutMap -> {
                val previouslist = mstate.value.previousWorkSpot
                val fallout = mstate.value.isFalloutMap
                val falloutcondition = mstate.value.isFalloutMap

                mstate.value = Mapscreenstate(
                    properties = MapProperties(
                        mapStyleOptions = if (fallout) null else MapStyleOptions(Mapstyle.json),

                    ),
                    previousWorkSpot = previouslist,
                    isFalloutMap = !falloutcondition,
                )
            }

            is MapScreenEvent.onInfoWindowLongClick -> {
                viewModelScope.launch {
                    repository.deletePreviousWorkLocation(
                        event.location,
                    )
                }
            }
            is MapScreenEvent.onMapLongClick -> {
                viewModelScope.launch {
                    repository.insertWorkLocation(
                        PreviousWorkLocation(
                            event.latitudeAndLongitude.latitude,
                            event.latitudeAndLongitude.longitude,
                        ),
                    )
                }
            }
        }
    }
}
