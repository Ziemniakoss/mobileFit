package com.mobilefit.ui.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilefit.R
import kotlinx.android.synthetic.main.exercise_list.exercise_category_textView
import kotlinx.android.synthetic.main.exercise_list.exercises_recyclerView
import kotlinx.android.synthetic.main.training_layout.*


class TrainingActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.training_layout)
		val training = intent.getStringExtra("training")
		training_textView.text = training
		trainingdescription_textView.text = TrainingsBase.getDesc(training)


	}
}