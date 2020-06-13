package com.mobilefit.data.exercises

import android.util.Log
import com.google.gson.Gson
import com.mobilefit.Variables
import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.NotFoundException
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class ExerciseCategoryRepository : IExerciseCategoryRepository {
	override fun get(id: Int): Result<ExerciseCategory> {
		for(category in ExerciseDataBase.cateegories){
			if(category.id == id)
				return Result.Success(category)
		}
		var category:ExerciseCategory
		return Result.Error(NotFoundException())
	}

	override fun getAll(): List<ExerciseCategory> {
		var categories:List<ExerciseCategory> = listOf()
		val t = Thread{
			Log.d("aaa","start")
			val req = Request.Builder()
				.url(Variables.urlToServer+"/exercises/categories")
				.get().build()
			val call = OkHttpClient().newCall(req)
			var result :List<ExerciseCategory>
			call.execute().use {
				val response:Response = it
				var res = response.body()?.string()
				Log.d("aaa",res)
				categories = Gson().fromJson(res, mutableListOf<ExerciseCategory>()::class.java)
			}
			Log.d("aaa","aaaaa")

		}
		t.start()
		t.join()
		return categories
	}
}