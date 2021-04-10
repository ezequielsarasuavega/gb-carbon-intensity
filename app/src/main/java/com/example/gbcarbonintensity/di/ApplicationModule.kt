package com.example.gbcarbonintensity.di

import com.example.gbcarbonintensity.data.source.GbCarbonIntensityRepositoryImpl
import com.example.gbcarbonintensity.data.source.GbCarbonIntensityDataSource
import com.example.gbcarbonintensity.data.source.GbCarbonIntensityRepository
import com.example.gbcarbonintensity.data.source.remote.GbCarbonIntensityRemoteDataSource
import com.example.gbcarbonintensity.data.source.remote.GbCarbonIntensityService
import com.example.gbcarbonintensity.data.source.remote.DateConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class GbCarbonIntensityRemoteDataSource

    @Singleton
    @GbCarbonIntensityRemoteDataSource
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

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}

@Module
abstract class ApplicationModuleBinds {

    @Suppress("UNUSED")
    @Singleton
    @Binds
    abstract fun bindGbCarbonIntensityRepository(
        repository: GbCarbonIntensityRepositoryImpl
    ): GbCarbonIntensityRepository

}
