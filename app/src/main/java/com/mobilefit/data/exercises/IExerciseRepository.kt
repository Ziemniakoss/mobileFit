package com.mobilefit.data.exercises

import com.mobilefit.data.Result

interface IExerciseRepository {
	fun getAllFromCategory(categoryId: Int): Result<List<Exercise>>
	fun getAllFromCategory(category: ExerciseCategory): Result<List<Exercise>>
	fun get(exerciseId: Int): Result<Exercise>
}