package com.example.gbcarbonintensity.carbonintensitydetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gbcarbonintensity.data.source.remote.CarbonIntensityResponse
import com.example.gbcarbonintensity.data.Result.Success
import com.example.gbcarbonintensity.data.source.GbCarbonIntensityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class CarbonIntensityDetailsViewModel @Inject constructor(
    private val carbonIntensityRepository: GbCarbonIntensityRepository
) : ViewModel() {

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _actualAverage = MutableLiveData<Int>()
    val actualAverage: LiveData<Int> = _actualAverage

    private val _forecastAverage = MutableLiveData<Int>()
    val forecastAverage: LiveData<Int> = _forecastAverage

    fun getCarbonIntensityForDate(date: Date) {

        _dataLoading.value = true

        viewModelScope.launch {

            val result = carbonIntensityRepository.getCarbonIntensityForDate(date)

            if (result is Success<CarbonIntensityResponse>) {

                _actualAverage.value = getActualAverage(result.data?.data ?: listOf())
                _forecastAverage.value = getForecastAverage(result.data?.data ?: listOf())

            } else {

                //TODO manage error

            }

            _dataLoading.value = false

        }

    }

    private fun getActualAverage(data: List<CarbonIntensityResponse.CarbonIntensityResponseData?>): Int {

        return data.map { it?.intensity?.actual ?: 0 }.average().roundToInt()

    }

    private fun getForecastAverage(data: List<CarbonIntensityResponse.CarbonIntensityResponseData?>): Int {

        return data.map { it?.intensity?.forecast ?: 0 }.average().roundToInt()

    }

}