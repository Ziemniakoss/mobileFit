package com.mobilefit.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilefit.R
import com.mobilefit.ui.training.TrainingAdapter
import kotlinx.android.synthetic.main.fragment_training.*

class DietFragment : Fragment() {
	private lateinit var dietViewModel: DietViewModel

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		dietViewModel =
			ViewModelProviders.of(this).get(DietViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_diet, container, false)


		return root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		diets_recyclerview.layoutManager = LinearLayoutManager(this.context)
		diets_recyclerview.adapter = DietAdapter()
	}

}