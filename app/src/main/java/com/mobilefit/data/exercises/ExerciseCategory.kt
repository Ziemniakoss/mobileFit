package com.mobilefit.data.exercises

data class ExerciseCategory(var id: Int = 0, var name: String = "") {
	override fun hashCode(): Int = id
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as ExerciseCategory

		if (id != other.id) return false

		return true
	}

}