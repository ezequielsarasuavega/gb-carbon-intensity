package com.example.gbcarbonintensity.data.source.remote.di

import com.example.gbcarbonintensity.data.source.GbCarbonIntensityDataSource
import com.example.gbcarbonintensity.data.source.remote.DateConverterFactory
import com.example.gbcarbonintensity.data.source.remote.GbCarbonIntensityRemoteDataSource
import com.example.gbcarbonintensity.data.source.remote.GbCarbonIntensityService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun provideGbCarbonIntensityRemoteDataSource(
        service: GbCarbonIntensityService
    ): GbCarbonIntensityDataSource {
        return GbCarbonIntensityRemoteDataSource(service)
    }

    @Singleton
    @Provides
    fun provideGbCarbonIntensityService(): GbCarbonIntensityService {

        return Retrofit.Builder()
            .baseUrl("https://api.carbonintensity.org.uk/intensity/")
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(DateConverterFactory())
            .build()
            .create(GbCarbonIntensityService::class.java)

    }

}
