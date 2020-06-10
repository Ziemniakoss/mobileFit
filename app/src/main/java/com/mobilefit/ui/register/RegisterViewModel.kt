package com.mobilefit.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilefit.R
import com.mobilefit.data.Result
import com.mobilefit.data.UserRepository

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {
	private val _formState = MutableLiveData<RegisterFormState>()
	val formState: LiveData<RegisterFormState> = _formState

	private val _result = MutableLiveData<RegisterResult>();
	val result: LiveData<RegisterResult> = _result

	fun register(
		username: String, email: String,
		password: String, validatePassword: String
	) {
		if (!formState.value!!.isValid())
			return

		Thread {
			val registerResult = userRepository.register(username, email, password)

			if (registerResult is Result.Success) {
				_result.postValue(RegisterResult(null))
			} else {
				_result.postValue(RegisterResult(R.string.error_unknown))
			}
		}.start()
	}

	fun dataChanged(
		username: String, email: String,
		password: String, validatePassword: String
	) {
		_formState.value = RegisterFormState(
			usernameError = isUsernameValid(username),
			emailError = isEmailValid(email),
			passwordError = isPasswordValid(password),
			passwordValidationError = isPasswordValidationValid(password, validatePassword)
		)
	}

	fun isUsernameValid(username: String): Int? {
		val trimmed = username.trim()
		if (trimmed.isEmpty()) {
			return R.string.error_blank;
		}
		if (trimmed.length < 3) {
			return R.string.error_too_short
		}
		return null
	}

	fun isEmailValid(email: String): Int? {
		val trimmed = email.trim()
		if (trimmed.isBlank())
			return R.string.error_blank
		return if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
			null
		else
			R.string.error_invalid_email
	}

	fun isPasswordValid(password: String): Int? {
		if (password.length < 5)
			return R.string.invalid_password
		return null
	}

	fun isPasswordValidationValid(password: String, passwordValidation: String): Int? {
		if (password == passwordValidation) {
			return null
		}
		return R.string.error_password_mismatch
	}
}