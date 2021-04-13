package com.example.gbcarbonintensity.carbonintensitydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.gbcarbonintensity.R
import com.example.gbcarbonintensity.databinding.FragmentCarbonIntensityDetailsBinding
import com.example.gbcarbonintensity.utils.DateUtils
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CarbonIntensityDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CarbonIntensityDetailsViewModel> { viewModelFactory }

    private lateinit var binding: FragmentCarbonIntensityDetailsBinding

    private val args: CarbonIntensityDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCarbonIntensityDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()

        loadData()

    }

    private fun setView() {

        viewModel.dataLoading.observe(viewLifecycleOwner, {
            binding.fragmentCarbonIntensityDetailsLoadingView.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        binding.fragmentCarbonIntensityDetailsHeader.text = getString(
            R.string.fragment_carbon_intensity_details_title,
            DateUtils.formatDisplayDate(args.date)
        )

        binding.fragmentCarbonIntensityDetailsActual.label.text = getString(
            R.string.fragment_carbon_intensity_details_actual_average_label
        )

        viewModel.actualAverage.observe(viewLifecycleOwner, {
            binding.fragmentCarbonIntensityDetailsActual.value.text = it.toString()
        })

        binding.fragmentCarbonIntensityDetailsForecast.label.text = getString(
            R.string.fragment_carbon_intensity_details_forecast_average_label
        )

        viewModel.forecastAverage.observe(viewLifecycleOwner, {
            binding.fragmentCarbonIntensityDetailsForecast.value.text = it.toString()
        })

    }

    private fun loadData() {

        viewModel.getCarbonIntensityForDate(args.date)

    }

}
