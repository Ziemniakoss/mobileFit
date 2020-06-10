package com.mobilefit.ui.stopper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StopperViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is exercises Fragment"
	}
	val text: LiveData<String> = _text
}