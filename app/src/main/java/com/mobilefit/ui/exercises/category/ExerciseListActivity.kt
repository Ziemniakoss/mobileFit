package com.mobilefit.ui.exercises.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilefit.R
import kotlinx.android.synthetic.main.exercise_list.exercise_category_textView
import kotlinx.android.synthetic.main.exercise_list.exercises_recyclerView


class ExerciseListActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.exercise_list)
		val categoryName = intent.getStringExtra("category")
		exercise_category_textView.text = categoryName

		exercises_recyclerView.layoutManager = LinearLayoutManager(this)
		val exerciseArray = ExerciseCategoryBase.getList(categoryName)
		exercises_recyclerView.adapter = ExerciseCategoryAdapter(exerciseArray)

	}
}