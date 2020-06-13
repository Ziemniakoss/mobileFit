package com.mobilefit.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mobilefit.MainActivity

import com.mobilefit.R
import com.mobilefit.data.exercises.ExerciseRepository
import com.mobilefit.ui.register.RegisterActivity
import com.mobilefit.utils.OnTextChangedListener
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

	private lateinit var loginViewModel: LoginViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)

		val username = findViewById<EditText>(R.id.tv_username)
		val password = findViewById<EditText>(R.id.tv_password)
		val login = findViewById<Button>(R.id.btn_login)

		loginViewModel = LoginViewModelFactory().create(LoginViewModel::class.java)

		loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
			val loginState = it ?: return@Observer

			// disable login button unless both username / password is valid
			Log.d("aaa", loginState.isValid().toString())
			login.isEnabled = loginState.isValid()
			if (loginState.usernameError != null) {
				username.error = getString(loginState.usernameError)
			}
			if (loginState.passwordError != null) {
				password.error = getString(loginState.passwordError)
			}
		})

		loginViewModel.loginResult.observe(this@LoginActivity, Observer {
			val loginResult = it ?: return@Observer
			if (loginResult.error != null) {
				showLoginFailed(loginResult.error)
			} else {
				setResult(Activity.RESULT_OK)
				val intent = Intent(this, MainActivity::class.java)
				Log.d("AAA", "logged in")
				startActivity(intent)
				finish()
			}
		})

		//zmiany danych
		tv_username.addTextChangedListener(OnTextChangedListener { _ ->
			loginViewModel.loginDataChanged(
				tv_username.text.toString(),
				tv_password.text.toString()
			)
		})
		tv_password.addTextChangedListener(OnTextChangedListener { _ ->
			loginViewModel.loginDataChanged(
				tv_username.text.toString(),
				tv_password.text.toString()
			)
		})
	}

	private fun showLoginFailed(@StringRes errorString: Int) {
		Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
	}

	fun registerPressed(view: View) {
		val intent = Intent(this, RegisterActivity::class.java)
		startActivity(intent)
	}

	fun loginPressed(view: View) {
		loginViewModel.login(tv_username.text.toString(), tv_password.text.toString())
	}
}
