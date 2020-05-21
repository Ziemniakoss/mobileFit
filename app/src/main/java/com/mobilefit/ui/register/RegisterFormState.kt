package com.mobilefit.ui.register

class RegisterFormState(
	val usernameError:Int?,
	val emailError:Int?,
	val passwordError:Int?,
	val passwordValidationError:Int?
){
	fun isValid():Boolean = usernameError == null &&
			emailError == null &&
			passwordError == null &&
			passwordValidationError == null
}