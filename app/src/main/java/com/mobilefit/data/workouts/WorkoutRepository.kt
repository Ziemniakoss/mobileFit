package com.mobilefit.data.workouts

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mobilefit.Variables
import com.mobilefit.data.Result
import com.mobilefit.data.exercises.Exercise
import com.mobilefit.data.quests.Quest
import com.mobilefit.data.users.UserRepository
import com.mobilefit.dto.QuestUpdateDTO
import com.mobilefit.dto.WorkoutCreationDTO
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException
import java.lang.reflect.Type

class WorkoutRepository {
	fun getAll(): Result<List<Workout>> {
		var result: Result<List<Workout>> = Result.Error(IOException())
		val t = Thread {
			val req = Request.Builder()
				.get()
				.header("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.url("${Variables.urlToServer}/workouts")
				.build()
			OkHttpClient().newCall(req).execute().use {
				val fooType: Type? = object : TypeToken<List<Workout?>?>() {}.type
				val quest = Gson().fromJson<List<Workout>>(it.body()?.string(), fooType)
				result = Result.Success(quest)
			}
		}
		t.start()
		t.join()
		return result
	}

	fun get(id: Int): Result<Workout> {
		var result: Result<Workout> = Result.Error(IOException())
		val t = Thread {
			val req = Request.Builder()
				.get()
				.header("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.url("${Variables.urlToServer}/workouts/${id}")
				.build()
			OkHttpClient().newCall(req).execute().use {
				val fooType: Type? = object : TypeToken<Workout?>() {}.type
				val quest = Gson().fromJson<Workout>(it.body()?.string(), fooType)
				result = Result.Success(quest)
			}
		}
		t.start()
		t.join()
		return result
	}

	fun add(exercise: Exercise, length: Int) {
		add(exercise.id, length)

	}

	fun add(exerciseId: Int, length: Int) {
		val t = Thread {
			val req = Request.Builder()
				.url("${Variables.urlToServer}/workouts")
				.post(
					RequestBody.create(
						Variables.jsonMediaType,
						Gson().toJson(WorkoutCreationDTO(exerciseId, length))
					)
				)
				.header("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.build()
			OkHttpClient().newCall(req).execute().use {
				Log.d("WORK", "WOrkout created")
			}
		}
		t.start()
		t.join()
	}
}