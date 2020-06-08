package com.mobilefit.ui.exercises

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.ui.exercises.category.ExerciseListActivity
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*


class ExercisesAdapter: RecyclerView.Adapter<ExercisesViewHolder>(){

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ExercisesViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val categoryRow = layoutInflater.inflate(R.layout.exercises_categoryrow, viewGroup, false)

		return ExercisesViewHolder(categoryRow)
	}

	override fun getItemCount(): Int {
		return ExercisesCategoriesBase.categoriesList.size
	}

	override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
		val category = holder.view.exercisecategories_button

		category.setText(ExercisesCategoriesBase.categoriesList[position])
		category.setOnClickListener{
			var intent: Intent= Intent(holder.view.context, ExerciseListActivity::class.java)
			intent.putExtra("category", ExercisesCategoriesBase.categoriesList[position])
			holder.view.context.startActivity(intent)
		}
	}

}




class ExercisesViewHolder(val view: View): RecyclerView.ViewHolder(view)
