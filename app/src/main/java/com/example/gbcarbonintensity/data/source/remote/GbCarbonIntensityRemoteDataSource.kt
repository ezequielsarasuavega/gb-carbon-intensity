package com.example.gbcarbonintensity.data.source.remote

import com.example.gbcarbonintensity.data.Result
import com.example.gbcarbonintensity.data.source.GbCarbonIntensityDataSource
import java.util.*

/**
 * Implementation of the network data source
 */
class GbCarbonIntensityRemoteDataSource internal constructor(
    private val service: GbCarbonIntensityService
) : GbCarbonIntensityDataSource {

    override suspend fun getCarbonIntensityForDate(date: Date): Result<CarbonIntensityResponse?> {
        return ApiResponse.toResult(service.getCarbonIntensityForDate(date))
    }

}