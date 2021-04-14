package com.example.gbcarbonintensity.common

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> Fragment.viewLifecycle(): ReadWriteProperty<Fragment, T> {

    return object : ReadWriteProperty<Fragment, T>, LifecycleObserver {

        // a backing property to hold our value
        private var binding: T? = null

        private var viewLifecycleOwner: LifecycleOwner? = null

        init {

            // observe the View Lifecycle of the Fragment
            this@viewLifecycle.viewLifecycleOwnerLiveData.observe(
                this@viewLifecycle,
                Observer { newLifecycleOwner ->
                    viewLifecycleOwner?.lifecycle?.removeObserver(this)
                    viewLifecycleOwner = newLifecycleOwner
                    viewLifecycleOwner?.lifecycle?.addObserver(this)
                })

        }

        @Suppress("unused")
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {

            // clear out backing property just before onDestroyView
            binding = null

        }

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {

            // return the backing property if it's set
            return this.binding!!

        }

        override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {

            // set the backing property
            this.binding = value

        }

    }

}