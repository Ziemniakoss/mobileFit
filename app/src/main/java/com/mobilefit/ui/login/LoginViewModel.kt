package com.mobilefit.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.mobilefit.data.UserRepository
import com.mobilefit.data.Result

import com.mobilefit.R

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

	private val _loginForm = MutableLiveData<LoginFormState>()
	val loginFormState: LiveData<LoginFormState> = _loginForm

	private val _loginResult = MutableLiveData<LoginResult>()
	val loginResult: LiveData<LoginResult> = _loginResult

	fun login(username: String, password: String) {
		// can be launched in a separate asynchronous job
		val result = userRepository.login(username, password)

		if (result is Result.Success) {
			_loginResult.value = LoginResult()
		} else {
			_loginResult.value = LoginResult(error = R.string.login_failed)
		}
	}

	fun loginDataChanged(username: String, password: String) {
		if (!isUserNameValid(username)) {
			_loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
		} else if (!isPasswordValid(password)) {
			_loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
		}
	}

	// A placeholder username validation check
	private fun isUserNameValid(username: String): Boolean {
		return Patterns.EMAIL_ADDRESS.matcher(username).matches()
	}

	// A placeholder password validation check
	private fun isPasswordValid(password: String): Boolean {
		return password.length > 5
	}
}
