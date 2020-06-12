package com.mobilefit.ui.daily

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.ui.diet.DietsBase
import kotlinx.android.synthetic.main.daily_categoryrow.view.*
import kotlinx.android.synthetic.main.exercises_categoryrow.view.*
import kotlinx.android.synthetic.main.fragment_daily.view.*


class DailyAdapter(questList: MutableList<String>): RecyclerView.Adapter<DailyViewHolder>(){

	var questList:MutableList<String> = questList

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DailyViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val questRow = layoutInflater.inflate(R.layout.daily_categoryrow, viewGroup, false)

		return DailyViewHolder(questRow)
	}

	override fun getItemCount(): Int {
		return questList.size
	}

	override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
		val questDescription = holder.view.dailyquest_textview
		val dailyDoneButton = holder.view.dailydone_button

		questDescription.text = questList[position]
		dailyDoneButton.setOnClickListener{

			/*dodanie punktow i wyslanie na backend*/
			/*tam powinno sie odchaczyc i przyslac liste bez zrobionego*/
			questList.remove(questDescription.text.toString())
			notifyItemRemoved(position)
		}


	}

}




class DailyViewHolder(val view: View): RecyclerView.ViewHolder(view)
