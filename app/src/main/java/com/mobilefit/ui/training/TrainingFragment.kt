package com.mobilefit.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilefit.R
import kotlinx.android.synthetic.main.fragment_training.*

class TrainingFragment :Fragment() {
	private lateinit var trainingViewModel: TrainingViewModel

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		trainingViewModel =
			ViewModelProviders.of(this).get(TrainingViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_training, container, false)


		return root
	}
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		diets_recyclerview.layoutManager = LinearLayoutManager(this.context)
		diets_recyclerview.adapter = TrainingAdapter()
	}

}