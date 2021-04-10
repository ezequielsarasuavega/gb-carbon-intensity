package com.example.gbcarbonintensity.data.source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface GbCarbonIntensityService {

    @GET("date/{date}")
    suspend fun getCarbonIntensityForDate(
        @Path("date") date: Date
    ): Response<CarbonIntensityResponse?>

}