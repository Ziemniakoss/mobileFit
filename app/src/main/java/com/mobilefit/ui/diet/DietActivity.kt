package com.mobilefit.ui.diet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobilefit.R
import kotlinx.android.synthetic.main.diet_layout.*


class DietActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.diet_layout)
		val diet = intent.getStringExtra("diet")
		diet_textView.text = diet
		dietdescription_textView.text = DietsBase.getDesc(diet)


	}
}