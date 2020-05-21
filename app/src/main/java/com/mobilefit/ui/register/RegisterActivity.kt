package com.mobilefit.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mobilefit.MainActivity
import com.mobilefit.R
import com.mobilefit.utils.OnTextChangedListener
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
	private lateinit var registerViewModel: RegisterViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_register)
		setTitle(R.string.title_activity_register)

		registerViewModel = RegisterViewModelFactory().create(RegisterViewModel::class.java)

		registerViewModel.formState.observe(this@RegisterActivity, Observer {
			println("aaaa")
			val registerState = it ?: return@Observer
			btn_register.isEnabled = registerState.isValid()
			println(btn_register.isEnabled)
			if (registerState.usernameError != null) {
				tv_username.error = getString(registerState.usernameError)
			}
			if (registerState.emailError != null) {
				tv_email.error = getString(registerState.emailError)
			}
			if (registerState.passwordError != null) {
				tv_password.error = getString(registerState.passwordError)
			}
			if (registerState.passwordValidationError != null) {
				tv_validatePassword.error = getString(registerState.passwordValidationError)
			}

		})
		//nasłuchiwanie zmian tekstu
		tv_username.addTextChangedListener(OnTextChangedListener{ _ ->dataUpdated()})
		tv_email.addTextChangedListener(OnTextChangedListener{ _ ->dataUpdated()})
		tv_password.addTextChangedListener(OnTextChangedListener{ _ ->dataUpdated()})
		tv_validatePassword.addTextChangedListener(OnTextChangedListener{ _ ->dataUpdated()})

		registerViewModel.result.observe(this@RegisterActivity, Observer {
			val result = it ?: return@Observer
			if(result.success()){
				val intent = Intent(this, MainActivity::class.java)
				startActivity(intent)
				finish()
			}else{
				Toast.makeText(this, "Failed to register", Toast.LENGTH_LONG).show()
			}

		})
	}

	fun dataUpdated() {
		registerViewModel.dataChanged(
			username = tv_username.text.toString(),
			password = tv_password.text.toString(),
			validatePassword = tv_validatePassword.text.toString(),
			email = tv_email.text.toString()
		)
	}

	fun register(view: View) {
		registerViewModel.register(
			username = tv_username.text.toString(),
			password = tv_password.text.toString(),
			validatePassword = tv_validatePassword.text.toString(),
			email = tv_email.text.toString()
		)
	}
}
