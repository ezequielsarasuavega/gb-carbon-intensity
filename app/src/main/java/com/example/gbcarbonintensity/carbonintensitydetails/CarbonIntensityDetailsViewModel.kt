package com.example.gbcarbonintensity.carbonintensitydetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject

class CarbonIntensityDetailsViewModel @Inject constructor() : ViewModel() {

    private val _date = MutableLiveData<Date>()
    val date: LiveData<Date> = _date

    fun loadCarbonIntensityDetailsForDate(date: Date) {
        setDate(date)
    }

    private fun setDate(date: Date) {
        _date.value = date
    }

}