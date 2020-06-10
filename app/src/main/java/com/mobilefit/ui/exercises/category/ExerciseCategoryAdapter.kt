package com.mobilefit.ui.exercises.category

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.ui.exercises.ExercisesCategoriesBase
import com.mobilefit.ui.exercises.exercise.ExerciseActivity
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*

class ExerciseCategoryAdapter(val exercisesArray: ArrayList<String>): RecyclerView.Adapter<ExerciseCategoryViewHolder>(){
	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ExerciseCategoryViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val categoryRow = layoutInflater.inflate(R.layout.exercises_categoryrow, viewGroup, false)
		return ExerciseCategoryViewHolder(categoryRow)
	}

	override fun getItemCount(): Int {
		return exercisesArray.size
	}

	override fun onBindViewHolder(holder: ExerciseCategoryViewHolder, position: Int) {
		val exercise = holder.view.exercisecategories_button

		exercise.setText(exercisesArray[position])
		exercise.setOnClickListener{
			var intent: Intent = Intent(holder.view.context, ExerciseActivity::class.java)
			intent.putExtra("exercise", exercisesArray[position])
			holder.view.context.startActivity(intent)
		}

	}

}

class ExerciseCategoryViewHolder(val view: View): RecyclerView.ViewHolder(view)
