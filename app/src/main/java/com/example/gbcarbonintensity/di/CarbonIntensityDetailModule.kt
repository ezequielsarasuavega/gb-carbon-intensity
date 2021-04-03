package com.example.gbcarbonintensity.di

import androidx.lifecycle.ViewModel
import com.example.gbcarbonintensity.carbonintensitydetails.CarbonIntensityDetailsFragment
import com.example.gbcarbonintensity.carbonintensitydetails.CarbonIntensityDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Dagger module for the carbon intensity details feature
 */
@Module
abstract class CarbonIntensityDetailModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun carbonIntensityDetailsFragment(): CarbonIntensityDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(CarbonIntensityDetailsViewModel::class)
    abstract fun bindCarbonIntensityDetailsViewModel(
        carbonIntensityDetailsViewModel: CarbonIntensityDetailsViewModel
    ): ViewModel

}

