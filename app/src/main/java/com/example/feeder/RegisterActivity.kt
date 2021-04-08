package com.example.feeder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register)
    }

    public fun clickSubmit(view: View) {
        val loginLayout = findViewById<EditText>(R.id.register_login_value)
        val passwordLayout = findViewById<EditText>(R.id.register_password_value)
        val passwordConfirmLayout = findViewById<EditText>(R.id.register_password_confirm_value)

        val loginText = loginLayout.text.toString();
        val passwordText = passwordLayout.text.toString();
        val passwordConfirmText = passwordConfirmLayout.text.toString();

        val loginTextValid = loginText.validator()
            .nonEmpty()
            .validEmail()
            .addErrorCallback {
                // Validation here
                loginLayout.error = getString(R.string.email_error)
            }
            .check()

        val passwordTextValid = passwordText.validator()
            .nonEmpty()
            .minLength(8)
            .atleastOneLowerCase()
            .atleastOneSpecialCharacters()
            .atleastOneUpperCase()
            .addErrorCallback {
                // Validation here
                passwordLayout.error = getString(R.string.password_error)
            }
            .check()

        val passwordConfirmationTextValid = passwordConfirmText.validator()
            .nonEmpty()
            .minLength(8)
            .atleastOneLowerCase()
            .atleastOneSpecialCharacters()
            .atleastOneUpperCase()
            .textEqualTo(passwordText)
            .addErrorCallback {
                // Validation here
                passwordConfirmLayout.error = getString(R.string.password_error)
            }
            .check()

        if(loginTextValid && passwordTextValid && passwordConfirmationTextValid) {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish();
        }
    }

    public fun clickBack(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish();
    }
}