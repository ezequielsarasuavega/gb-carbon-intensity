package com.example.gbcarbonintensity.data.source.remote

import com.example.gbcarbonintensity.data.Result
import com.example.gbcarbonintensity.data.source.GbCarbonIntensityDataSource
import java.lang.Exception
import java.util.*

/**
 * Implementation of the network data source
 */
class GbCarbonIntensityRemoteDataSource internal constructor(
    private val service: GbCarbonIntensityService
) : GbCarbonIntensityDataSource {

    override suspend fun getCarbonIntensityForDate(date: Date): Result<CarbonIntensityResponse?> {

        return try {

            ApiResponse.toResult(service.getCarbonIntensityForDate(date))

        } catch (runtime: Exception) {

            Result.Error()

        }

    }

}