package com.codepath.memelib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CollectionAdapter(val context: Context, private val collections: List<Collections>)
    : RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCollectionName : TextView = itemView.findViewById(R.id.tvCollectionName)
        private val deleteButton : ImageView = itemView.findViewById(R.id.deleteButton)

        fun bind(collection: Collections){
            tvCollectionName.setText(collection.getName())

            deleteButton.setOnClickListener {
                deleteCollection(collection)
            }
        }

        private fun deleteCollection(collection: Collections) {
            openDialog()
        }

        private fun openDialog() {
//            val removeCollectionDialog = RemoveCollectionDialog()
//            removeCollectionDialog.show(getSupportFragmentManager(), "deleteContactDialog")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_collection, parent, false)
        return CollectionAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionAdapter.ViewHolder, position: Int) {
        val collection = collections.get(position)
        holder.bind(collection)
    }

    override fun getItemCount(): Int {
        return collections.size
    }
}
