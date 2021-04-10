package com.example.gbcarbonintensity.data.source

import com.example.gbcarbonintensity.data.source.remote.CarbonIntensityResponse
import com.example.gbcarbonintensity.data.Result
import java.util.*

/**
 * Interface to the data layer
 */
interface GbCarbonIntensityRepository {

    suspend fun getCarbonIntensityForDate(date: Date = Date()): Result<CarbonIntensityResponse?>

}