package com.codepath.memelib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {

    lateinit var logoutbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logoutbtn = findViewById<Button>(R.id.btnLogout)
        logoutbtn.isEnabled = ParseUser.getCurrentUser() != null

        logoutbtn.setOnClickListener {
            //Launch the camera for the user to take picture
            ParseUser.logOut()
            goToLoginActivity()
        }
    }

    private fun goToLoginActivity() {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()             //closes the MainActivity, avoiding going back to main page on clicking back
    }
}