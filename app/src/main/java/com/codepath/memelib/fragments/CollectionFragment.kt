package com.codepath.memelib.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codepath.memelib.Post
import com.codepath.memelib.R
import com.parse.ParseQuery
import com.parse.ParseUser

/**
 * A simple [Fragment] subclass.
 * Use the [CollectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CollectionFragment : FeedFragment() {

    override fun queryPosts() {
        // SwipeRefresh: Clear posts first
        allPosts.clear()

        // SwipeRefresh: Populate again
        //specify which class to query
        // Specify which class to query
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser())
        query.include(Post.KEY_USER)

        //return posts in descending order based on posted time
        query.addDescendingOrder("createdAt")

        query.findInBackground { posts, e ->
            if (e != null) {
                Log.e(FeedFragment.TAG, "Error fetching posts")
            } else {
                if (posts != null) {
                    for (post in posts) {
                        Log.i(FeedFragment.TAG, "Post: " + post.getDescription() + " , username: " + post.getUser()?.username)
                    }

                    allPosts.addAll(posts)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}