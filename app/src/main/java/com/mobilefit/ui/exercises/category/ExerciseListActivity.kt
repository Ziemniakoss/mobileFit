package com.mobilefit.ui.exercises.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilefit.R
import com.mobilefit.data.exercises.ExerciseRepository

import kotlinx.android.synthetic.main.exercise_list.exercise_category_textView
import kotlinx.android.synthetic.main.exercise_list.exercises_recyclerView


class ExerciseListActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.exercise_list)
		val categoryName = intent.getStringExtra("categoryName")
		val categoryId = intent.getStringExtra("categoryId").toInt()
		exercise_category_textView.text = categoryName

		exercises_recyclerView.layoutManager = LinearLayoutManager(this)

		var exerciseRepository = ExerciseRepository()

		exercises_recyclerView.adapter = ExerciseCategoryAdapter(exerciseRepository, categoryId)

	}
}