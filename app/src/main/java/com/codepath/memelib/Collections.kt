package com.codepath.memelib

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import org.json.JSONArray

@ParseClassName("Collections")
class Collections : ParseObject() {

    fun getDescription() : String? {
        return getString(Collections.KEY_DESCRIPTION)
    }

    fun setDescription(description : String) {
        put(Collections.KEY_DESCRIPTION, description)
    }

    fun getName() : ParseFile?{
        return getParseFile(Collections.KEY_NAME)
    }

    fun setName(parseFile: ParseFile) {
        put(Collections.KEY_NAME, parseFile)
    }

    fun getUser() : ParseUser? {
        return getParseUser(Collections.KEY_USER)
    }

    fun setUser(user : ParseUser) {
        put(Collections.KEY_USER, user)
    }

    fun getCollection() : JSONArray? {
        return getJSONArray(Collections.KEY_COLLECTION)
    }

    fun setCollection(collection : List<Post>) {
        put(Collections.KEY_COLLECTION, collection)
    }

    fun getID() : String? {
        return getString(Collections.KEY_ID)
    }

    companion object {
        const val KEY_DESCRIPTION = "description"
        const val KEY_NAME = "name"
        const val KEY_USER = "user"
        const val KEY_ID = "objectId"
        const val KEY_COLLECTION = "collection" //array stored with posts
    }
}