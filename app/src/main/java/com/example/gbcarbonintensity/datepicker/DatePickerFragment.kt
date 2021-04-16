package com.example.gbcarbonintensity.datepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gbcarbonintensity.common.viewLifecycle
import com.example.gbcarbonintensity.databinding.FragmentDatePickerBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DatePickerFragment : Fragment() {

    private companion object {

        private const val THREE_DAYS_BEFORE = -3
        private const val THREE_DAYS_AFTER = 3

    }

    private var binding: FragmentDatePickerBinding by viewLifecycle()

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
            submitList(getDatesList())
        }

    }

    private fun getDatesList(): List<Date> {

        val listOfDates = mutableListOf<Date>()
        for (i in THREE_DAYS_AFTER downTo THREE_DAYS_BEFORE) {
            val date = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, i) }
            listOfDates.add(date.time)
        }

        return listOfDates

    }

    private fun openCarbonIntensityDetails(date: Date) {

        findNavController().navigate(
            DatePickerFragmentDirections.actionDatePickerFragmentToCarbonIntensityDetailsFragment(date)
        )

    }

}
