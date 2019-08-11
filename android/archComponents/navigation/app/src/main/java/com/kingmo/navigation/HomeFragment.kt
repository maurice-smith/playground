package com.kingmo.navigation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.kingmo.navigation.databinding.HomeFragmentBinding


class HomeFragment : Fragment(), NextListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // Obtain binding
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        // Bind layout with ViewModel
        binding.homeViewModel = viewModel

        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this

        viewModel.resources = resources
        viewModel.listener = this

        viewModel.updateUserName("Billy")
        return binding.root
    }

    override fun onNextClick() {
        findNavController(this).navigate(R.id.go_to_details_action)
    }
}
