package com.example.gbcarbonintensity.datepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gbcarbonintensity.common.EventObserver
import com.example.gbcarbonintensity.databinding.FragmentDatePickerBinding
import dagger.android.support.DaggerFragment
import java.util.*
import javax.inject.Inject

class DatePickerFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DatePickerViewModel> { viewModelFactory }

    private lateinit var viewDataBinding: FragmentDatePickerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewDataBinding = FragmentDatePickerBinding.inflate(inflater, container, false)
            .apply {
                this.viewModel = this@DatePickerFragment.viewModel
            }

        return viewDataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()

        setNavigation()

        loadData()

    }

    private fun setUi() {

        // set the lifecycle owner to the lifecycle of the view
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        viewDataBinding.fragmentDatePickerRecyclerView.adapter = DatesAdapter(viewModel)

    }

    private fun setNavigation() {

        viewModel.openCarbonIntensityDetailsEvent.observe(viewLifecycleOwner, EventObserver {
            openCarbonIntensityDetails(it)
        })

    }

    private fun openCarbonIntensityDetails(date: Date) {

        findNavController().navigate(
            DatePickerFragmentDirections.actionDatePickerFragmentToCarbonIntensityDetailsFragment(date)
        )

    }

    private fun loadData() {

        viewModel.loadDates()

    }

}
