package com.codepath.memelib.dialogs.profilefragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment
import com.codepath.memelib.R

class RemoveCollectionDialog : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.remove_collection_dialog, null)
        builder.setView(view)
            .setNegativeButton(
                "No"
            ) { dialogInterface: DialogInterface?, i: Int -> }
            .setPositiveButton(
                "Yes"
            ) { dialogInterface: DialogInterface?, i: Int -> listener.removeCollection() }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
//            listener = (RemoveCollectionDialogListener) context
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement deleteContactDialogListener"
            )
        }
    }

    interface RemoveCollectionDialogListener {
        fun removeCollection()
    }

    companion object {
        lateinit var listener: RemoveCollectionDialogListener
    }

}