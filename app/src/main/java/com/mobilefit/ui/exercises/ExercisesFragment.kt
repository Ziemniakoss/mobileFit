package com.mobilefit.ui.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobilefit.R
import com.mobilefit.data.exercises.ExerciseCategoryRepository
import kotlinx.android.synthetic.main.fragment_exercises.*

class ExercisesFragment : Fragment() {
	private lateinit var exercisesViewModel: ExercisesViewModel

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		exercisesViewModel =
			ViewModelProviders.of(this).get(ExercisesViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_exercises, container, false)


		return root

	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		var exerciseCategoryAdapter: ExerciseCategoryRepository = ExerciseCategoryRepository()
		var categoriesList = exerciseCategoryAdapter.getAll()

		exercises_recyclerView.layoutManager = LinearLayoutManager(this.context)
		exercises_recyclerView.adapter = ExercisesAdapter(categoriesList)
	}
}