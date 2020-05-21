package com.mobilefit.data

import android.util.Log
import com.mobilefit.data.model.User
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
object UserDataSource {
	private val TAG = "UserDataSource"

	fun login(username: String, password: String): Result<User> {
		//todo faktyczny login
		if(!"fit@gmail.com".equals(username) || !"123456".equals(password)){
			return Result.Error(IOException("USER_DOES_NOT_EXIST"))
		}
		return Result.Success(User(java.util.UUID.randomUUID().toString(), "Fit Person", "fit@gmail.com","123456"))
	}

	fun register(username: String,email:String, password: String):Result<User>{
		if("fit@gmail.com" == email) {
			Log.d(TAG, "User already exists")
			return Result.Error(IOException("USER_ALREADY_EXISTS"))
		}
		if(password.length < 5){
			Log.d(TAG, "Illegal password")
			return Result.Error(IOException("PASSWORD_TOO_SHORT"))
		}
		return Result.Success(User(
			userId = java.util.UUID.randomUUID().toString(),
			username = username,
			email = email,
			jwt = null))
	}

	fun logout() {
		// TODO: revoke authentication
	}
}

