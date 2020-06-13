package com.mobilefit.ui.exercises.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobilefit.R
import com.mobilefit.data.exercises.ExerciseRepository
import kotlinx.android.synthetic.main.exercise_layout.*


class ExerciseActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.exercise_layout)
		val exerciseId = intent.getStringExtra("exerciseId").toInt()

		var exerciseRepository = ExerciseRepository()
		var exercise = exerciseRepository.get(exerciseId)

		diet_textView.text = exercise.get()!!.name
		trainingdescription_textView.text = exercise.get()!!.description


	}
}