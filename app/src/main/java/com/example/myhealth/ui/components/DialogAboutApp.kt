package com.example.myhealth.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.myhealth.databinding.DialogAbotAppBinding

class DialogAboutApp(
    private val onSubmitClickListener: (Float) -> Unit
): DialogFragment() {

    private lateinit var binding : DialogAbotAppBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogAbotAppBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btn.setOnClickListener {
           dismiss()
        }


        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}