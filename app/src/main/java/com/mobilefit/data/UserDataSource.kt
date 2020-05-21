package com.mobilefit.data

import com.mobilefit.data.model.User
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class UserDataSource {

	fun login(username: String, password: String): Result<User> {
		//todo faktyczny login
		if(!"fit@gmail.com".equals(username) || !"123456".equals(password)){
			return Result.Error(IOException("USER_DOES_NOT_EXIST"))
		}
		return Result.Success(User(java.util.UUID.randomUUID().toString(), "Fit Person", "fit@gmail.com","123456"))
	}

	fun logout() {
		// TODO: revoke authentication
	}
}

