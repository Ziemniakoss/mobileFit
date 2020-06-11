package com.mobilefit.ui.calories

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilefit.R
import com.mobilefit.ui.diet.DietViewModel
import kotlinx.android.synthetic.main.fragment_calories.*
import kotlin.math.round

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

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		calories_recyclerView.layoutManager = LinearLayoutManager(this.context)
		calories_recyclerView.adapter = CaloriesAdapter(chooseFood_textView, cal_input)

		cal_input.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(s: Editable?) {
				if(cal_input.text.toString() != ""){
					var cal:Double = cal_input.text.toString().toDouble() * CaloriesBase.getCalories(chooseFood_textView.text.toString())
					cal = round(cal*100)/100
					cal_textView.setText(cal.toString())
				}
			}

			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
			}

			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

			}

		})

	}
}