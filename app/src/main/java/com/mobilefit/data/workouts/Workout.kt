package com.mobilefit.data.workouts

import com.mobilefit.data.exercises.Exercise
import java.sql.Date

data class Workout(
	var id:Int = 0,
	var duration:Int = 0,
	var exercise: Exercise? = null,
	var calories:Int = 0
)