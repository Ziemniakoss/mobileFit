package com.mobilefit.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilefit.data.UserDataSource
import com.mobilefit.data.UserRepository
import java.lang.IllegalArgumentException

class RegisterViewModelFactory : ViewModelProvider.Factory {
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(RegisterViewModel::class.java))
			return RegisterViewModel(UserRepository(UserDataSource)) as T
		throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
	}
}