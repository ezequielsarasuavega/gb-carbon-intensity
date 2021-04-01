package com.example.gbcarbonintensity.di

import androidx.lifecycle.ViewModel
import com.example.gbcarbonintensity.list.ListFragment
import com.example.gbcarbonintensity.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Dagger module for the list feature
 */
@Module
abstract class ListModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun listFragment(): ListFragment

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindViewModel(listViewmodel: ListViewModel): ViewModel

}

