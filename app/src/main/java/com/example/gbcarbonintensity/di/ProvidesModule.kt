package com.example.gbcarbonintensity.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvidesModule {

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}
