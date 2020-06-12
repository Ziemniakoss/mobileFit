package com.mobilefit.data.weights

import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.NotFoundException

class WeightMeasurementsDataSource {
	private val measurements = ArrayList<WeightMeasurement>()
	fun get(id: Int): Result<WeightMeasurement> {
		for (i in 0 until measurements.size)
			if (measurements[i].id == id)
				return Result.Success(measurements[i])
		return Result.Error(NotFoundException())
	}

	fun add(measurement: WeightMeasurement) {

	}

	fun getAll(): Result<List<WeightMeasurement>> {
		return Result.Success(measurements as List<WeightMeasurement>)

	}

	fun getLast(): Result<WeightMeasurement> {
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