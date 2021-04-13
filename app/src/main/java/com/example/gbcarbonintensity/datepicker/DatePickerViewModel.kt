package com.example.gbcarbonintensity.datepicker

import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject

class DatePickerViewModel @Inject constructor() : ViewModel() {

    private companion object {

        private const val THREE_DAYS_BEFORE = -3
        private const val THREE_DAYS_AFTER = 3

    }

    val dates: List<Date> = getDatesList()

    private fun getDatesList(): List<Date> {

        val listOfDates = mutableListOf<Date>()
        for (i in THREE_DAYS_AFTER downTo THREE_DAYS_BEFORE) {
            val date = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, i) }
            listOfDates.add(date.time)
        }

        return listOfDates

    }

}