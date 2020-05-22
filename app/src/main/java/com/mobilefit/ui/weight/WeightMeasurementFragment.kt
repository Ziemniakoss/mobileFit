package com.mobilefit.ui.weight

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobilefit.R


class WeightMeasurementFragment : Fragment() {

	private lateinit var viewModel: WeightMeasurementViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.weight_measurement_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProviders.of(this).get(WeightMeasurementViewModel::class.java)
		// TODO: Use the ViewModel
	}

}
