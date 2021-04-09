package com.example.feeder

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
    }

    public fun clickSubmit(view: View) {
        val loginText = findViewById<EditText>(R.id.login_value).text.toString()
        val passwordText = findViewById<EditText>(R.id.login_password_value).text.toString()

        if (loginText == "admin" && passwordText == "okon") {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
            builder.setTitle(resources.getString(R.string.whats_new))

            // Set up the input
            val input = EditText(this)
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setHint(resources.getString(R.string.verf_code))
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            // Set up the buttons
            builder.setPositiveButton(resources.getString(R.string.ok), DialogInterface.OnClickListener { dialog, which ->
                // Here you get get input text from the Edittext
                val m_Text = input.text.toString()

                if (m_Text == "2137") {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish();
                }
            })
            builder.setNegativeButton(resources.getString(R.string.cancel), DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

            builder.show()
        }
    }

    public fun clickRegister(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish();
    }

    fun clickLoginGoogle(view: View) {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish();
    }
}