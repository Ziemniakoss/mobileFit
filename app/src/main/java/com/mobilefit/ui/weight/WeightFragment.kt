package com.mobilefit.ui.weight

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.mobilefit.R
import kotlinx.android.synthetic.main.fragment_weight.*

class WeightFragment : Fragment() {

	private lateinit var weightViewModel: WeightViewModel

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		weightViewModel =
			ViewModelProviders.of(this).get(WeightViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_weight, container, false)
		return root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		btn_newMeasurement.setOnClickListener { newMeasurementClicked() }
	}

	private fun newMeasurementClicked() {
		Log.d("WEIGHT", "Starting new weight activity")
		val action = WeightFragmentDirections.actionWeightFragmentToWeightMeasurementFragment()
		NavHostFragment.findNavController(this@WeightFragment).navigate(action)
	}
}
