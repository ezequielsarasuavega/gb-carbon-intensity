package com.example.gbcarbonintensity

import com.example.gbcarbonintensity.di.DaggerApplicationComponent
import dagger.android.support.DaggerApplication

/**
 * An [Application] that uses Dagger for Dependency Injection
 */
class GbCarbonIntensityApplication : DaggerApplication() {

    override fun applicationInjector() = DaggerApplicationComponent.factory().create(applicationContext)

}
