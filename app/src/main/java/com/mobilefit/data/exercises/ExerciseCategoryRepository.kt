package com.mobilefit.data.exercises

import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.NotFoundException

class ExerciseCategoryRepository : IExerciseCategoryRepository {
	override fun get(id: Int): Result<ExerciseCategory> {
		for(category in ExerciseDataBase.cateegories){
			if(category.id == id)
				return Result.Success(category)
		}
		return Result.Error(NotFoundException())
	}

	override fun getAll(): List<ExerciseCategory> {
		return ExerciseDataBase.cateegories
	}
}