package com.mobilefit.data

import com.google.gson.Gson
import com.mobilefit.Variables
import com.mobilefit.data.exceptions.LoginTakenException
import com.mobilefit.data.model.User
import com.mobilefit.dto.UserDTO
import okhttp3.*

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class UserRepository(val dataSource: UserDataSource) {

	// in-memory cache of the loggedInUser object
	var user: User? = null
		private set

	val isLoggedIn: Boolean
		get() = user != null

	init {
		// If user credentials will be cached in local storage, it is recommended it be encrypted
		// @see https://developer.android.com/training/articles/keystore
		user = null
	}

	fun logout() {
		user = null
		dataSource.logout()
	}

	fun login(email: String, password: String): Result<User> {
		// handle login
		val result = dataSource.login(email, password)

		if (result is Result.Success) {
			setLoggedInUser(result.data)
		}

		return result
	}

	/**
	 * Rejestruje i loguje jeżeli udało siee zarejestrować
	 */
	fun register( email: String, password: String): Result<User> {
		val result = dataSource.register(email = email, password = password)
		return if (result is Result.Success) {
			dataSource.login(email, password);
		} else {
			Result.Error(LoginTakenException())
		}
	}

	private fun setLoggedInUser(user: User) {
		this.user = user
		// If user credentials will be cached in local storage, it is recommended it be encrypted
		// @see https://developer.android.com/training/articles/keystore
	}
}
