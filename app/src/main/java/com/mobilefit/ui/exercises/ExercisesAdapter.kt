package com.mobilefit.ui.exercises

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.data.exercises.ExerciseCategory
import com.mobilefit.ui.exercises.category.ExerciseListActivity
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*


class ExercisesAdapter(categoriesList :List<ExerciseCategory>): RecyclerView.Adapter<ExercisesViewHolder>(){

	var categoriesList:List<ExerciseCategory> = categoriesList

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ExercisesViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val categoryRow = layoutInflater.inflate(R.layout.exercises_categoryrow, viewGroup, false)

		return ExercisesViewHolder(categoryRow)
	}

	override fun getItemCount(): Int {
		return categoriesList.size
	}

	override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
		val category = holder.view.exercisecategories_button


		System.out.println(categoriesList.get(position).name)
		/*category.setText(categoriesList[position].name)

		category.setOnClickListener{
			var intent: Intent= Intent(holder.view.context, ExerciseListActivity::class.java)
			intent.putExtra("category", ExercisesCategoriesBase.categoriesList[position])
			holder.view.context.startActivity(intent)
		}*/
	}

}




class ExercisesViewHolder(val view: View): RecyclerView.ViewHolder(view)
