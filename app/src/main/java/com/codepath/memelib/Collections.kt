package com.codepath.memelib

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import org.json.JSONArray

@ParseClassName("Collections")
class Collections : ParseObject() {

    fun getDescription() : String? {
        return getString(KEY_DESCRIPTION)
    }

    fun setDescription(description : String) {
        put(KEY_DESCRIPTION, description)
    }

    fun getName() : String?{
        return getString(KEY_NAME)
    }

    fun setName(name : String) {
        put(KEY_NAME, name)
    }

    fun getUser() : ParseUser? {
        return getParseUser(KEY_USER)
    }

    fun setUser(user : ParseUser) {
        put(KEY_USER, user)
    }

    fun getCollection() : JSONArray? {
        return getJSONArray(KEY_COLLECTION)
    }

    fun setCollection(collection : List<Post>) {
        put(KEY_COLLECTION, collection)
    }

    fun getID() : String? {
        return getString(KEY_ID)
    }

    companion object {
        const val KEY_DESCRIPTION = "description"
        const val KEY_NAME = "name"
        const val KEY_USER = "user"
        const val KEY_ID = "objectId"
        const val KEY_COLLECTION = "collection" //array stored with posts
    }
}