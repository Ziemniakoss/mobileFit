package com.mobilefit.data.exercises

data class Exercise(var id: Int = 0, var name: String = "", var met: Double = 1.0, var description: String = "") {
	override fun hashCode(): Int = id
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Exercise

		if (id != other.id) return false

		return true
	}
}