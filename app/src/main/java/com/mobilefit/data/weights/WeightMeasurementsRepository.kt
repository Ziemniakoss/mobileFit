package com.mobilefit.data.weights

import com.mobilefit.data.Result

class WeightMeasurementsRepository() {
	private val dataSource = WeightMeasurementsDataSource
	fun get(id: Int): Result<WeightMeasurement> {
		return dataSource.get(id)
	}

	fun add(measurement: WeightMeasurement) {
		dataSource.add(measurement)
	}

	fun getAll(): Result<List<WeightMeasurement>> {
		return dataSource.getAll()
	}

	fun getLast(): Result<WeightMeasurement> = dataSource.getLast()
}