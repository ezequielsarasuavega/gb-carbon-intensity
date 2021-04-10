package com.example.gbcarbonintensity.data.source.remote

/**
 * Immutable model class for the carbon intensity
 */
data class CarbonIntensityResponse(

    val data: List<CarbonIntensityResponseData?>

) {

    data class CarbonIntensityResponseData(

        val intensity: CarbonIntensity

    ) {

        data class CarbonIntensity(

            val index: String,

            val forecast: Int,

            val actual: Int

        )

    }

}
