package com.example.gbcarbonintensity.data.source

import com.example.gbcarbonintensity.data.source.remote.CarbonIntensityResponse
import com.example.gbcarbonintensity.data.Result
import java.util.*

/**
 * Main entry point for accessing carbon emissions data
 */
interface GbCarbonIntensityDataSource {

    suspend fun getCarbonIntensityForDate(date: Date = Date()): Result<CarbonIntensityResponse?>

}