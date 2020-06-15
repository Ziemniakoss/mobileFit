package com.mobilefit.ui.weight

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.mobilefit.R
import com.mobilefit.data.weights.WeightMeasurement
import com.mobilefit.data.weights.WeightMeasurementsDataSource
import com.mobilefit.data.weights.WeightMeasurementsRepository
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kotlinx.android.synthetic.main.fragment_weight.*
import kotlinx.android.synthetic.main.fragment_weight.lineChart
import java.time.LocalDateTime
import java.util.*

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

		var weightRepository = WeightMeasurementsRepository()
		var lastMeasurements = weightRepository.getAll().get()
		var lastMeasureId = lastMeasurements!!.size-1

		var weight = weightRepository.getAll().get()!![lastMeasureId].value
		var textToDisplay = "Last measurement:\n" + weight + "kg"

		tv_lastWeight.text = textToDisplay


/*Wykres*/
		//Part1
		val entries = ArrayList<Entry>()

//Part2

		for(i in lastMeasurements){
			entries.add(Entry(i.id!!.toFloat(), i.value!!.toFloat()))
		}
		/*
		entries.add(Entry(1f, 10f))
		entries.add(Entry(2f, 2f))
		entries.add(Entry(3f, 7f))
		entries.add(Entry(4f, 20f))
		entries.add(Entry(5f, 16f))*/

//Part3
		val vl = LineDataSet(entries, "My Weight")

//Part4
		vl.setDrawValues(false)
		vl.setDrawFilled(true)
		vl.lineWidth = 3f
		vl.fillColor = R.color.textColor
		///vl.fillAlpha = R.color.textColor

//Part5
		lineChart.xAxis.labelRotationAngle = 0f

//Part6
		lineChart.data = LineData(vl)

//Part7
		lineChart.axisRight.isEnabled = false
		lineChart.xAxis.axisMaximum = 20f

//Part8
		lineChart.setTouchEnabled(true)
		lineChart.setPinchZoom(true)

//Part9
		lineChart.description.text = "Days"
		lineChart.setNoDataText("No forex yet!")

		btn_newMeasurement.setOnClickListener { newMeasurementClicked() }
	}

	private fun newMeasurementClicked() {
		Log.d("WEIGHT", "Starting new weight activity")
		val action = WeightFragmentDirections.actionWeightFragmentToWeightMeasurementFragment()
		NavHostFragment.findNavController(this@WeightFragment).navigate(action)
	}
}
