package com.mobilefit.ui.exercises.category

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.data.exercises.Exercise
import com.mobilefit.data.exercises.ExerciseRepository
import com.mobilefit.ui.exercises.ExercisesCategoriesBase
import com.mobilefit.ui.exercises.exercise.ExerciseActivity
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*

class ExerciseCategoryAdapter(exerciseRepository: ExerciseRepository, categoryId: Int): RecyclerView.Adapter<ExerciseCategoryViewHolder>(){
	var exerciseRepository = exerciseRepository
	var exercisesList = exerciseRepository.getAllFromCategory(categoryId)

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ExerciseCategoryViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val categoryRow = layoutInflater.inflate(R.layout.exercises_categoryrow, viewGroup, false)
		return ExerciseCategoryViewHolder(categoryRow)
	}

	override fun getItemCount(): Int {
		return exercisesList.get()!!.size
	}

	override fun onBindViewHolder(holder: ExerciseCategoryViewHolder, position: Int) {
		val exerciseButton = holder.view.exercisecategories_button

		var exerciseId = exercisesList.get()!![position].id
		var exercise = exerciseRepository.get(exerciseId).get()

		exerciseButton.setText(exercise!!.name)

		exerciseButton.setOnClickListener{
			var intent: Intent = Intent(holder.view.context, ExerciseActivity::class.java)
			intent.putExtra("exerciseId", exerciseId.toString())
			holder.view.context.startActivity(intent)
		}

	}

}

class ExerciseCategoryViewHolder(val view: View): RecyclerView.ViewHolder(view)
