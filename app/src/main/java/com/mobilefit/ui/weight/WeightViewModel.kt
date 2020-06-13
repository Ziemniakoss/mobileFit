package com.mobilefit.ui.weight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilefit.data.weights.WeightMeasurementsDataSource
import com.mobilefit.data.weights.WeightMeasurementsRepository
import com.mobilefit.data.weights.WeightMeasurement

class WeightViewModel : ViewModel() {
	private val _weights = MutableLiveData<List<WeightMeasurement>>()
	val weights: LiveData<List<WeightMeasurement>> = _weights

	private val _latestMeasurement = MutableLiveData<WeightMeasurement>()
	val latestMeasurement: LiveData<WeightMeasurement> = _latestMeasurement

	private val repository =
		WeightMeasurementsRepository()//todo di

	private val _text = MutableLiveData<String>().apply {
		value = "This is gallery Fragment"
	}
	val text: LiveData<String> = _text
}