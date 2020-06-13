package com.mobilefit.data.weights

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mobilefit.Variables
import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.NotFoundException
import com.mobilefit.data.exercises.ExerciseCategory
import com.mobilefit.data.users.UserDataSource
import com.mobilefit.data.users.UserRepository
import com.mobilefit.dto.WeightCreationDTO
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException
import java.lang.reflect.Type

object WeightMeasurementsDataSource {
	private val measurements = ArrayList<WeightMeasurement>()
	fun get(id: Int): Result<WeightMeasurement> {
		var result:Result<WeightMeasurement> = Result.Error(IOException())
		val t = Thread{
			val req = Request.Builder()
				.get()
				.url("${Variables.urlToServer}/weights/${id}")
				.addHeader("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.build()
			OkHttpClient().newCall(req).execute().use {
				if(!it.isSuccessful){
					result = Result.Error(NotFoundException())//niedokładnie ale przejdzie
				}else{
					val fooType: Type? = object : TypeToken<WeightMeasurement?>() {}.type
					result = Result.Success(Gson().fromJson(it.body()?.string(), fooType))
				}
			}
		}
		return result
	}

	fun add(measurement: WeightMeasurement) {
		val t = Thread {
			val dto = WeightCreationDTO(measurement.value)
			val req = Request.Builder()
				.url("${Variables.urlToServer}/weights")
				.post(RequestBody.create(Variables.jsonMediaType, Gson().toJson(dto)))
				.addHeader("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.build()
			OkHttpClient().newCall(req).execute().use {
				val response: Response = it
			}
		}
		t.start()
		t.join()
	}

	fun getAll(): Result<List<WeightMeasurement>> {
		var result: Result<List<WeightMeasurement>> = Result.Error(IOException())
		val t = Thread {
			val req = Request.Builder()
				.url("${Variables.urlToServer}/weights")
				.header("Authorization", "Bearer ${UserRepository.user?.jwt}")
				.get()
				.build()
			OkHttpClient().newCall(req).execute().use {
				val response: Response = it
				val fooType: Type? = object : TypeToken<List<WeightMeasurement?>?>() {}.type
				val weights = Gson().fromJson<List<WeightMeasurement>>(response.body()?.string(), fooType)
				result = Result.Success(weights)
			}
		}
		t.start()
		t.join()
		return result
	}

	fun getLast(): Result<WeightMeasurement> {//todo
		if (measurements.size < 1)
			return Result.Error(NotFoundException())
		var res = measurements[0]
		for (i in 1 until measurements.size) {
			if (measurements[i].date.after(res.date)) {
				res = measurements[i]
			}
		}
		return Result.Success(res)
	}
}