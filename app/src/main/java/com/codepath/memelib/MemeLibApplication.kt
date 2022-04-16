package com.codepath.memelib

import android.app.Application
import com.parse.Parse

// Code snippet Implemented from Back4app official documentation
class MemeLibApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Parse on application launch
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build())
    }
}