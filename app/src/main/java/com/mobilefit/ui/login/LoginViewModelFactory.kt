package com.mobilefit.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilefit.data.UserDataSource
import com.mobilefit.data.UserRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
			return LoginViewModel(
				UserRepository(dataSource = UserDataSource)
			) as T
		}
		throw IllegalArgumentException("Unknown ViewModel class")
	}
}
