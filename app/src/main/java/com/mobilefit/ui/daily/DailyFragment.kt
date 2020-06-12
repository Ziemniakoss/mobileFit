package com.mobilefit.ui.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilefit.R
import com.mobilefit.data.quests.QuestRepository
import kotlinx.android.synthetic.main.fragment_daily.*

class DailyFragment : Fragment() {

    private lateinit var dailyViewModel: DailyViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dailyViewModel =
                ViewModelProviders.of(this).get(DailyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_daily, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var questRepository = QuestRepository()

        daily_recyclerview.layoutManager = LinearLayoutManager(this.context)
        daily_recyclerview.adapter = DailyAdapter(questRepository)
    }



}
