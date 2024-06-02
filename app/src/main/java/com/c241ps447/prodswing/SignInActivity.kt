package com.c241ps447.prodswing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.c241ps447.prodswing.databinding.ActivitySignInBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.apply {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // button
            loginButton.setOnClickListener {
                showLoading(true)
                runBlocking { delay(1000) }
                showToast("Success")
                showLoading(false)
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                finish()
            }

            forgotPasswordTextView.setOnClickListener {  }
            signUpTextView.setOnClickListener { startActivity(Intent(this@SignInActivity, SignUpActivity::class.java)) }

        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}