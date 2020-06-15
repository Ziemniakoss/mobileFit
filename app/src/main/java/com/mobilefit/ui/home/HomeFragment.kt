package com.mobilefit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.mobilefit.R
import com.mobilefit.data.quests.QuestRepository
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

	private lateinit var homeViewModel: HomeViewModel

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		homeViewModel =
			ViewModelProviders.of(this).get(HomeViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_home, container, false)

		return root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		var questList = QuestRepository().getAll().get()

		var exp = 0

		for(quest in questList!!){
			if(quest.completed == true){
				exp += quest.xp
			}
		}

		var level = exp / 2000
		exp = exp % 2000


		var expToNextLevel = 2000
		var procent = (exp.toFloat()/expToNextLevel.toFloat() *100).toInt()
		progressBar.progress = procent
		level2_view.text = level.toString()
		exp2_textview.text = exp.toString()
		exptonextlevel2_textview.text = expToNextLevel.toString()

	}
}
