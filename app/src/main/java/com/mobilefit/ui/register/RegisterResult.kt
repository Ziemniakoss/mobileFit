package com.mobilefit.ui.register

class RegisterResult(
	val error:Int?
)
{
	fun success():Boolean = error == null
}