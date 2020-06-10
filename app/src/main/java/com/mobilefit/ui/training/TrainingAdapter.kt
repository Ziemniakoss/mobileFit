package com.mobilefit.ui.training

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.ui.exercises.category.ExerciseListActivity
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*


class TrainingAdapter: RecyclerView.Adapter<TrainingViewHolder>(){

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TrainingViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val categoryRow = layoutInflater.inflate(R.layout.exercises_categoryrow, viewGroup, false)

		return TrainingViewHolder(categoryRow)
	}

	override fun getItemCount(): Int {
		return TrainingsBase.trainingList.size
	}

	override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
		val category = holder.view.exercisecategories_button

		category.setText(TrainingsBase.trainingList[position])
		category.setOnClickListener{
			var intent: Intent= Intent(holder.view.context, TrainingActivity::class.java)
			intent.putExtra("training", TrainingsBase.trainingList[position])
			holder.view.context.startActivity(intent)
		}

	}

}




class TrainingViewHolder(val view: View): RecyclerView.ViewHolder(view)
