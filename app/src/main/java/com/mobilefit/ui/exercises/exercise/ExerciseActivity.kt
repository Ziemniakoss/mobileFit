package com.mobilefit.ui.exercises.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobilefit.R
import com.mobilefit.data.exercises.ExerciseRepository
import com.mobilefit.data.workouts.WorkoutRepository
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

		workout_button.setOnClickListener{
				var czas = 0
			if(time_input.text.toString() != ""){
				czas += time_input.text.toString().toInt() * 60 * 60
			}

			if(time_input2.text.toString() != ""){
				czas += time_input2.text.toString().toInt() * 60
			}

			if(time_input3.text.toString() != ""){
				czas += time_input3.text.toString().toInt()
			}

			WorkoutRepository().add(exerciseId, czas.toInt())

			workout_button.setText("OK!")
			workout_button.setBackgroundColor(0)

		}

	}
}