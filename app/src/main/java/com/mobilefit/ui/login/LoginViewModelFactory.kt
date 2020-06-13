package com.mobilefit.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilefit.data.users.UserDataSource
import com.mobilefit.data.users.UserRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
			return LoginViewModel(
				UserRepository
			) as T
		}
		throw IllegalArgumentException("Unknown ViewModel class")
	}
}
