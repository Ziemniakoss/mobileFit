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
		Thread{
			val result = userRepository.login(username, password)
			if (result is Result.Success) {
				_loginResult.postValue(LoginResult())
			} else {
				_loginResult.postValue(LoginResult(error = R.string.login_failed))
			}
		}.start()
	}

	fun loginDataChanged(username: String, password: String) {
		_loginForm.value = LoginFormState(
			usernameError = isUserNameValid(username),
			passwordError = isPasswordValid(password)
		)
	}

	private fun isUserNameValid(username: String): Int? {
		val usernameTrimmed = username.trim()
		if(usernameTrimmed.isEmpty()){
			return R.string.error_blank
		}
		if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
			return R.string.error_invalid_email
		}
		return null
	}

	private fun isPasswordValid(password: String): Int? {
		if(password.length <=5){
			return R.string.invalid_password
		}
		return null
	}
}
