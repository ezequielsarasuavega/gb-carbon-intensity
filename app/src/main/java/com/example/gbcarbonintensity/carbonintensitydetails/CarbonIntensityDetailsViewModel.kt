package com.example.gbcarbonintensity.carbonintensitydetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gbcarbonintensity.data.source.remote.CarbonIntensityResponse
import com.example.gbcarbonintensity.data.Result.Success
import com.example.gbcarbonintensity.data.source.GbCarbonIntensityRepository
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class CarbonIntensityDetailsViewModel @Inject constructor(
    private val carbonIntensityRepository: GbCarbonIntensityRepository
) : ViewModel() {

    private val _date = MutableLiveData<Date>()
    val date: LiveData<Date> = _date

    fun getCarbonIntensityForDate(date: Date) {

        setDate(date)

        viewModelScope.launch {

            carbonIntensityRepository.getCarbonIntensityForDate(date).let { result ->

                if (result is Success<CarbonIntensityResponse>) {
                    //TODO manage success
                } else {
                    //TODO manage error
                }

            }

        }

    }

    private fun setDate(date: Date) {
        _date.value = date
    }

}