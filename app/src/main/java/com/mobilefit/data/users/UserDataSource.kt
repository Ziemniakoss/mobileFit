package com.mobilefit.data.users

import android.util.Log
import com.google.gson.Gson
import com.mobilefit.Variables
import com.mobilefit.data.Result
import com.mobilefit.data.exceptions.IllegalCredentials
import com.mobilefit.dto.LoginResponse
import com.mobilefit.dto.UserDTO
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
object UserDataSource {
	private val TAG = "UserDataSource"

	fun login(username: String, password: String): Result<User> {
		val body = RequestBody.create(Variables.jsonMediaType, Gson().toJson(UserDTO(username, password)))
		val req = Request.Builder()
			.post(body)
			.url(Variables.urlToServer + "/login")
			.build()
		val call = OkHttpClient().newCall(req)
		call.execute().use {
			if (it == null) {
				return Result.Error(IOException())
			}
			if (!it.isSuccessful) {

				return Result.Error(IllegalCredentials())
			}
			val response: Response = it;
			var body = if (response.body() != null) response.body()!!.string() else ""
			Log.d("DOUSUNIECIA", body)
			val parsed = Gson().fromJson(body, LoginResponse::class.java)
			return Result.Success(User(username, parsed.token))
		}
	}

	fun register( email: String, password: String): Result<User?> {
		val body = RequestBody.create(Variables.jsonMediaType, Gson().toJson(UserDTO(email, password)))
		val request = Request.Builder()
			.post(body)
			.url(Variables.urlToServer + "/users/register")
			.build()
		val call = OkHttpClient().newCall(request)
		lateinit var result: Result<User?>
		call.execute().use {
			if (it == null) {
				return@use;
			}
			val response: Response = it
			if (response.isSuccessful) {
				Log.d("REGISTER_SOURCE", "Udało sie zarejsetrować")
				result = Result.Success<User?>(null)
			} else {
				Log.e("REGISTER_SOURCE", "nie udało się zarejestrować: body: ${response.body()?.string()}, status ${it.code()}")
				result = Result.Error(IllegalCredentials());
			}
		}
		return result;
	}

	fun logout() {
		// TODO: revoke authentication
	}
}

