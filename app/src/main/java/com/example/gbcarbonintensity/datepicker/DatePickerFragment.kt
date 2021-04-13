package com.example.gbcarbonintensity.datepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gbcarbonintensity.databinding.FragmentDatePickerBinding
import dagger.android.support.DaggerFragment
import java.util.*
import javax.inject.Inject

class DatePickerFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DatePickerViewModel> { viewModelFactory }

    private lateinit var binding: FragmentDatePickerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDatePickerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()

    }

    private fun setView() {

        binding.fragmentDatePickerRecyclerView.adapter = DatesAdapter(object : OnDateClickListener {

            override fun onClick(date: Date) {
                openCarbonIntensityDetails(date)
            }

        }).apply {
            submitList(viewModel.dates)
        }

    }

    private fun openCarbonIntensityDetails(date: Date) {

        findNavController().navigate(
            DatePickerFragmentDirections.actionDatePickerFragmentToCarbonIntensityDetailsFragment(date)
        )

    }

}
