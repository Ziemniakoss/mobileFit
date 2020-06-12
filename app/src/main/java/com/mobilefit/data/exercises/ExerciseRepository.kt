package com.mobilefit.data.exercises

import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.NotFoundException
import java.util.*

class ExerciseRepository : IExerciseRepository {
	override fun getAllFromCategory(categoryId: Int): Result<List<Exercise>> {
		return getAllFromCategory(ExerciseCategory(id = categoryId))
	}

	override fun getAllFromCategory(category: ExerciseCategory): Result<List<Exercise>> {
		val exercises = ExerciseDataBase.db[category]
		return if(exercises == null){
			Result.Error(NotFoundException())
		}else{
			Result.Success(exercises)
		}
	}

	override fun get(exerciseId: Int) :Result<Exercise>{
		for (exercise in ExerciseDataBase.exercises){
			if(exercise.id == exerciseId){
				return Result.Success(exercise)
			}
		}
		return Result.Error(NotFoundException())
	}
}