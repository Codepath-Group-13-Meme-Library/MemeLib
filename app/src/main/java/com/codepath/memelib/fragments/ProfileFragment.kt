package com.codepath.memelib.fragments

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.codepath.memelib.LoginActivity
import com.codepath.memelib.R
import com.codepath.memelib.SoundClick
import com.parse.ParseUser

class ProfileFragment(override var mp: MediaPlayer? = null) : Fragment(), SoundClick{

    lateinit var logoutbtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun startSound() {
        super.startSound()
        if (mp == null) {
            mp = MediaPlayer.create(requireContext(), R.raw.sample)
        }
        mp?.start()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var fragmentToShow: Fragment? = MyPostsFragment()
        if (fragmentToShow != null) {
            fragmentManager?.beginTransaction()?.replace(R.id.flContainer, fragmentToShow)?.commit()
        }
        Toast.makeText(requireContext(), "My Posts", Toast.LENGTH_SHORT).show()

        logoutbtn = view.findViewById<Button>(R.id.btnLogout)
        logoutbtn.isEnabled = ParseUser.getCurrentUser() != null

        logoutbtn.setOnClickListener {
            //Launch the camera for the user to take picture
            startSound()
            ParseUser.logOut()
            goToLoginActivity()
        }
    }

    private fun goToLoginActivity() {
        val intent = Intent(this.requireContext(), LoginActivity::class.java)
        startActivity(intent)
        //finish()             //closes the MainActivity, avoiding going back to main page on clicking back
    }
}