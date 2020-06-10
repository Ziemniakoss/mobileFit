package com.mobilefit.ui.register

class RegisterFormState(
	val emailError: Int?,
	val passwordError: Int?,
	val passwordValidationError: Int?
) {
	fun isValid(): Boolean = emailError == null &&
			passwordError == null &&
			passwordValidationError == null
}