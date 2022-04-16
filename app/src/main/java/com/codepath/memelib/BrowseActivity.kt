package com.codepath.memelib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast



class BrowseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)

        findViewById<Button>(R.id.btnBackToLogin).setOnClickListener {
            goToLoginActivity()
            Toast.makeText(this, "Visitor go to login", Toast.LENGTH_SHORT).show()
        }
    }



    // could see 10 posts
    // has no bottom bar


    private fun goToLoginActivity() {
        val intent = Intent(this@BrowseActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()             //closes the MainActivity, avoiding going back to main page on clicking back
    }
}