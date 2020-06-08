package com.mobilefit.ui.exercises.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobilefit.R
import kotlinx.android.synthetic.main.exercise_layout.*


class ExerciseActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.exercise_layout)
		val exercise = intent.getStringExtra("exercise")
		training_textView.text = exercise
		trainingdescription_textView.text = ExerciseBase.getDesc(exercise)


	}
}