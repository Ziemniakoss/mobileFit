package com.mobilefit.ui.diet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*


class DietAdapter: RecyclerView.Adapter<DietViewHolder>(){

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DietViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val categoryRow = layoutInflater.inflate(R.layout.exercises_categoryrow, viewGroup, false)

		return DietViewHolder(categoryRow)
	}

	override fun getItemCount(): Int {
		return DietsBase.dietsList.size
	}

	override fun onBindViewHolder(holder: DietViewHolder, position: Int) {
		val category = holder.view.exercisecategories_button

		category.setText(DietsBase.dietsList[position])
		category.setOnClickListener{
			var intent: Intent = Intent(holder.view.context, DietActivity::class.java)
			intent.putExtra("diet", DietsBase.dietsList[position])
			holder.view.context.startActivity(intent)
		}


	}

}




class DietViewHolder(val view: View): RecyclerView.ViewHolder(view)
