package com.mobilefit.ui.weight

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobilefit.R
import com.mobilefit.data.weights.WeightMeasurement
import com.mobilefit.data.weights.WeightMeasurementsRepository
import kotlinx.android.synthetic.main.fragment_calories.*
import kotlinx.android.synthetic.main.weight_measurement_fragment.*
import java.util.*


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

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)



		weight_button.setOnClickListener{
			if(weight_input.text.toString() != ""){
				var weight:Double = weight_input.text.toString().toDouble()
				var weightRepository = WeightMeasurementsRepository()
				var lastMeasureId = weightRepository.getAll().get()!!.size


				weightRepository.add(WeightMeasurement(lastMeasureId, Date(), weight))
				System.out.println("dadsadsadsadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
			}
		}


	}







}
