package com.codepath.memelib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codepath.memelib.fragments.ComposeFragment
import com.codepath.memelib.fragments.FeedFragment
import com.codepath.memelib.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
                item ->

            var fragmentToShow: Fragment? = null

            when(item.itemId) {
                R.id.action_home -> {
                    fragmentToShow = FeedFragment()
                    Toast.makeText(this, "Home", LENGTH_SHORT).show()
                }
                R.id.action_profile -> {
                    fragmentToShow = ProfileFragment()
                    Toast.makeText(this, "Profile", LENGTH_SHORT).show()
                }
                R.id.action_compose -> {
                    fragmentToShow = ComposeFragment()
                    Toast.makeText(this, "Compose", LENGTH_SHORT).show()
                }
            }

            if(fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }
            true
        }

        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home
    }

    companion object {
        const val TAG = "MainActivity"
    }
}