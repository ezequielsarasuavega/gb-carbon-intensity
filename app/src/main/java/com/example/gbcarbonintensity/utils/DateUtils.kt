package com.example.gbcarbonintensity.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    const val DISPLAY_DATE_PATTERN = "EEEE, dd MMMM"

    fun formatDate(date: Date) = SimpleDateFormat(DISPLAY_DATE_PATTERN, Locale.getDefault()).format(date)

}