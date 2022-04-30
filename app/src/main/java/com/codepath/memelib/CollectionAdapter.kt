package com.codepath.memelib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.codepath.memelib.dialogs.feedfragment.AddToCollectionDialog
import com.codepath.memelib.dialogs.feedfragment.EditCollectionDialog
import com.codepath.memelib.dialogs.feedfragment.RemoveCollectionDialog

class CollectionAdapter(val context: Context, private val collections: List<Collections>)
    : RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCollectionName : TextView = itemView.findViewById(R.id.tvCollectionName)
        private val deleteButton : ImageView = itemView.findViewById(R.id.deleteButton)
        private val editButton : ImageView = itemView.findViewById(R.id.editButton)

        fun bind(collection: Collections){
            tvCollectionName.setText(collection.getName())

            deleteButton.setOnClickListener {
                deleteCollection(collection)
            }

            editButton.setOnClickListener {
                EditCollection(collection)
            }
        }

        private fun EditCollection(collection: Collections) {
            val EditCollectionDialog = EditCollectionDialog()
            val fragmentManager = (itemView.getContext() as FragmentActivity).supportFragmentManager
            EditCollectionDialog.show(fragmentManager, "EditCollectionDialog")
        }

        private fun deleteCollection(collection: Collections) {
            val RemoveCollectionDialog = RemoveCollectionDialog()
            val fragmentManager = (itemView.getContext() as FragmentActivity).supportFragmentManager
            RemoveCollectionDialog.show(fragmentManager, "removeCollectionDialog")
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