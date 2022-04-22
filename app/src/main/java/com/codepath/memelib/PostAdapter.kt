package com.codepath.memelib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL

class PostAdapter(val context: Context, val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        // specify layout file to use for this item
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts.get(position)
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvUsername: TextView
        val tvDescription: TextView
        val ivImage: ImageView
        val tvTimeCreated: TextView
        // buttons for optional stories
        val ivFavorite: ImageView
        val ivBookmark: ImageView
        val ivShareButton: ImageView

        init {
            tvUsername = itemView.findViewById(R.id.tvUsername)
            tvDescription = itemView.findViewById(R.id.tvDescription)
            ivImage = itemView.findViewById(R.id.ivImage)
            tvTimeCreated = itemView.findViewById(R.id.tvTimeCreated)
            ivFavorite = itemView.findViewById(R.id.ivFavorite)
            ivBookmark = itemView.findViewById(R.id.ivBookmark)
            ivShareButton = itemView.findViewById(R.id.ivShare)
        }

        fun bind(post: Post) {
            tvDescription.text = post.getDescription()
            tvUsername.text = "@" + post.getUser()?.username
            tvTimeCreated.text = post.createdAt.toString()

            // Populate image
            Glide.with(itemView.context)
                .load(post.getImage()?.url)
                .fitCenter() // scale to fit entire image within ImageView
                .into(ivImage)

        }
    }

    //https://developer.android.com/training/sharing/send sharing on other apps
//    fun sharePost(uriToImage: URI) {
//        val shareIntent: Intent = Intent().apply {
//            action = Intent.ACTION_SEND
//            putExtra(Intent.EXTRA_STREAM, uriToImage)
//            type = "image/jpeg"
//        }
//        startActivity(Intent.createChooser(shareIntent, null))
//    }
}