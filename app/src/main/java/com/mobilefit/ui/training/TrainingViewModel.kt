package com.mobilefit.ui.training

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrainingViewModel : ViewModel() {
	private val _text = MutableLiveData<String>().apply {
		value = "This is exercises Fragment"
	}
	val text: LiveData<String> = _text
}