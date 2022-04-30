package com.codepath.memelib.dialogs.feedfragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment
import com.codepath.memelib.R

class AddToCollectionDialog : AppCompatDialogFragment()  {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.add_to_collection_dialog, null)
        //put list of choices
//        builder.setView(view)
//            .setAdapter()
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
//            listener = (AddToCollectionDialogListener) context
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement deleteContactDialogListener"
            )
        }
    }

    interface AddToCollectionDialogListener {
        fun addToCollection()
    }

    companion object {
        lateinit var listener: AddToCollectionDialogListener
    }
}