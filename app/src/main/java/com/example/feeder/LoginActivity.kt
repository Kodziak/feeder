package com.example.feeder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
    }

    public fun clickSubmit(view: View) {
        val loginText = findViewById<EditText>(R.id.login_value).text.toString()
        val passwordText = findViewById<EditText>(R.id.login_password_value).text.toString()

        if (loginText == "admin" && passwordText == "okon") {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish();
        }
    }

    public fun clickRegister(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish();
    }
}