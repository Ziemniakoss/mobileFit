package com.mobilefit.ui.calories

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView


import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.ui.exercises.category.ExerciseListActivity
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*


class CaloriesAdapter(textView: TextView, editText: EditText): RecyclerView.Adapter<CaloriesViewHolder>(){

	var textViewFood = textView
	var editText = editText

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CaloriesViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val categoryRow = layoutInflater.inflate(R.layout.exercises_categoryrow, viewGroup, false)

		return CaloriesViewHolder(categoryRow)
	}

	override fun getItemCount(): Int {
		return CaloriesBase.caloriesList.size
	}

	override fun onBindViewHolder(holder: CaloriesViewHolder, position: Int) {
		val category = holder.view.exercisecategories_button

		category.setText(CaloriesBase.caloriesList[position])
		category.setOnClickListener{
			textViewFood.text = CaloriesBase.caloriesList[position]
			if(editText.text.toString() != ""){
				var tmp = editText.text
				editText.text = tmp
			}
		}
	}

}




class CaloriesViewHolder(val view: View): RecyclerView.ViewHolder(view)
