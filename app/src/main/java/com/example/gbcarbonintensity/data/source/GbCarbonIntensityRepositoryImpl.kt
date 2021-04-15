package com.example.gbcarbonintensity.data.source

import com.example.gbcarbonintensity.data.source.remote.CarbonIntensityResponse
import com.example.gbcarbonintensity.data.Result
import com.example.gbcarbonintensity.data.Result.Success
import com.example.gbcarbonintensity.data.Result.Error
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

/**
 * Concrete implementation to load carbon emissions from the remote data source.
 */
class GbCarbonIntensityRepositoryImpl @Inject constructor(
    private val remoteDataSource: GbCarbonIntensityDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GbCarbonIntensityRepository {

    override suspend fun getCarbonIntensityForDate(date: Date): Result<CarbonIntensityResponse?> {

        return withContext(ioDispatcher) {

            when (val gbCarbonIntensity = remoteDataSource.getCarbonIntensityForDate(date)) {

                is Success -> {

                    (gbCarbonIntensity as? Success)?.let {
                        return@withContext Success(it.data)
                    }

                }

                is Error -> {

                    (gbCarbonIntensity as? Error)?.let {
                        return@withContext Error(it.errorMessage)
                    }

                }

            }

            return@withContext Error(null)

        }

    }

}