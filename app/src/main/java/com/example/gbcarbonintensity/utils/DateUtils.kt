package com.example.gbcarbonintensity.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private const val DISPLAY_DATE_PATTERN = "EEEE, dd MMMM"
    private const val SERVICE_DATE_PATTERN = "yyyy-MM-dd"

    fun formatDisplayDate(date: Date): String = SimpleDateFormat(DISPLAY_DATE_PATTERN, Locale.getDefault()).format(date)

    fun formatServiceDate(date: Date): String = SimpleDateFormat(SERVICE_DATE_PATTERN, Locale.getDefault()).format(date)

}