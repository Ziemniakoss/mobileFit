package com.mobilefit.data.users

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User(
	val email: String,
	val jwt: String?
)
