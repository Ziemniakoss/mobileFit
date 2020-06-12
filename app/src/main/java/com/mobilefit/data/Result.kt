package com.mobilefit.data

import java.lang.Error

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T : Any?> {

	data class Success<out T : Any?>(val data: T) : Result<T>()
	data class Error(val exception: Exception) : Result<Nothing>()

	override fun toString(): String {
		return when (this) {
			is Success<*> -> "Success[data=$data]"
			is Error -> "Error[exception=$exception]"
		}
	}

	fun get():T?{
		return when (this){
			is Success<T> -> this.data
			else -> null
		}
	}
}
