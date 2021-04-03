package com.example.gbcarbonintensity.carbonintensitydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.gbcarbonintensity.databinding.FragmentCarbonIntensityDetailsBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CarbonIntensityDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CarbonIntensityDetailsViewModel> { viewModelFactory }

    private lateinit var viewDataBinding: FragmentCarbonIntensityDetailsBinding

    private val args: CarbonIntensityDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewDataBinding = FragmentCarbonIntensityDetailsBinding.inflate(inflater, container, false)
            .apply {
                this.viewModel = this@CarbonIntensityDetailsFragment.viewModel
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

    }

    private fun loadData() {

        viewModel.loadCarbonIntensityDetailsForDate(args.date)

    }

}
