package com.mobilefit.ui.daily


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.data.quests.QuestRepository
import kotlinx.android.synthetic.main.daily_categoryrow.view.*


class DailyAdapter(questRepository: QuestRepository): RecyclerView.Adapter<DailyViewHolder>(){

	var questRepository = questRepository
	var questList = questRepository.getAll()

	override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DailyViewHolder {
		val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
		val questRow = layoutInflater.inflate(R.layout.daily_categoryrow, viewGroup, false)

		return DailyViewHolder(questRow)
	}

	override fun getItemCount(): Int {
		return questList.get()?.size!!
	}

	@SuppressLint("ResourceAsColor")
	override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
		val questDescription = holder.view.dailyquest_textview
		val dailyDoneButton = holder.view.dailydone_button
		val questId = questList.get()!![position].id
		val quest = questRepository.get(questId).get()

		val textToDisplay = " "+ quest!!.name+" | "+ quest!!.xp +" XP" + "\n "+ quest!!.description

		questDescription.text = textToDisplay
		if(!quest.completed) {
			dailyDoneButton.setOnClickListener {
				/*zaznaczenie wykonanego cwiczenia*/
				questRepository.markAs(quest, true)
				dailyDoneButton.setText("OK!")
				dailyDoneButton.setBackgroundColor(0)
			}
		} else{
			dailyDoneButton.setText("OK!")
			dailyDoneButton.setBackgroundColor(0)
		}

	}

}




class DailyViewHolder(val view: View): RecyclerView.ViewHolder(view)
