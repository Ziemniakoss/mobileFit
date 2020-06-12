package com.mobilefit.data.exercises

import com.mobilefit.data.Result

interface IExerciseCategoryRepository {
	fun get(id: Int): Result<ExerciseCategory>
	fun getAll(): List<ExerciseCategory>
}