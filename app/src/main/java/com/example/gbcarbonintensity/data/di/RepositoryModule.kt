package com.example.gbcarbonintensity.data.di

import com.example.gbcarbonintensity.data.source.GbCarbonIntensityRepository
import com.example.gbcarbonintensity.data.source.GbCarbonIntensityRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Suppress("unused")
    @Singleton
    @Binds
    abstract fun bindGbCarbonIntensityRepository(
        repository: GbCarbonIntensityRepositoryImpl
    ): GbCarbonIntensityRepository

}
