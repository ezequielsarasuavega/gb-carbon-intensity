package com.example.gbcarbonintensity.datepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.gbcarbonintensity.databinding.FragmentDatePickerBinding
import dagger.android.support.DaggerFragment
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
                this.viewmodel = viewModel
            }

        return viewDataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()

        loadData()

    }

    private fun setUi() {

        // set the lifecycle owner to the lifecycle of the view
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        viewDataBinding.fragmentDatePickerRecyclerView.adapter = DatesAdapter(viewModel)

    }

    private fun loadData() {

        viewModel.loadDates()

    }

}
