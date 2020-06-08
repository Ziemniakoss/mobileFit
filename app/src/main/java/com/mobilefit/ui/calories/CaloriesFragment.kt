package com.mobilefit.ui.calories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mobilefit.R
import com.mobilefit.ui.diet.DietViewModel

class CaloriesFragment :Fragment() {
	private lateinit var caloriesViewModel: CaloriesViewModel

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		caloriesViewModel =
			ViewModelProviders.of(this).get(CaloriesViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_calories, container, false)


		return root
	}
}