package com.example.gbcarbonintensity.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    const val DISPLAY_DATE_PATTERN = "EEEE, dd MMMM"
    const val SERVICE_DATE_PATTERN = "yyyy-MM-dd"

    fun formatDisplayDate(date: Date) = SimpleDateFormat(DISPLAY_DATE_PATTERN, Locale.getDefault()).format(date)

    fun formatServiceDate(date: Date) = SimpleDateFormat(SERVICE_DATE_PATTERN, Locale.getDefault()).format(date)

}