package com.example.gbcarbonintensity.di

import androidx.lifecycle.ViewModel
import com.example.gbcarbonintensity.datepicker.DatePickerFragment
import com.example.gbcarbonintensity.datepicker.DatePickerViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Dagger module for the date picker feature
 */
@Module
abstract class DatePickerModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun datePickerFragment(): DatePickerFragment

    @Binds
    @IntoMap
    @ViewModelKey(DatePickerViewModel::class)
    abstract fun bindDatePickerViewModel(datePickerViewModel: DatePickerViewModel): ViewModel

}

