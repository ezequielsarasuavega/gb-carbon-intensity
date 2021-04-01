package com.example.gbcarbonintensity.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.gbcarbonintensity.databinding.FragmentListBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<ListViewModel> { viewModelFactory }

    private lateinit var viewDataBinding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewDataBinding = FragmentListBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }
        return viewDataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set the lifecycle owner to the lifecycle of the view
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

    }

}
