package com.mobilefit.data.exercises

import com.google.gson.Gson
import com.mobilefit.Variables
import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.NotFoundException
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*

class ExerciseRepository : IExerciseRepository {
	override fun getAllFromCategory(categoryId: Int): Result<List<Exercise>> {
		return getAllFromCategory(ExerciseCategory(id = categoryId))
	}

	override fun getAllFromCategory(category: ExerciseCategory): Result<List<Exercise>> {
		var exercises = listOf<Exercise>()
		val t = Thread {
			val req = Request.Builder()
				.get()
				.url("${Variables.urlToServer}/exercises/categories/${category.id}/exercises")
				.build()
			val call = OkHttpClient().newCall(req)
			call.execute().use {
				val response: Response = it
				exercises = Gson().fromJson(response.body()?.string(), mutableListOf<Exercise>()::class.java)
			}
		}
		t.start()
		t.join()
		return Result.Success(exercises)
	}

	override fun get(exerciseId: Int): Result<Exercise> {
		var result: Result<Exercise> = Result.Error(IOException())
		val t = Thread {
			val req = Request.Builder()
				.get()
				.url("${Variables.urlToServer}/exercises/${exerciseId}")
				.build()
			OkHttpClient().newCall(req).execute().use {
				val response: Response = it
				if(response.isSuccessful){
					result = Result.Success(Gson().fromJson(response.body()?.string(), Exercise::class.java))
				}else if(response.code() == 404){
					result = Result.Error(NotFoundException())
				}
			}
		}
		t.start()
		t.join()
		return result
	}
}