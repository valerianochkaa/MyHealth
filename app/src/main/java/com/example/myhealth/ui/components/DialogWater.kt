package com.example.myhealth.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myhealth.databinding.DialogWaterBinding

class DialogWater(
    private val onSubmitClickListener: (Float) -> Unit
): DialogFragment() {

    private lateinit var binding : DialogWaterBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogWaterBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnClose.setOnClickListener {
            dismiss()
        }

        binding.btnSave.setOnClickListener {
            Toast.makeText(requireContext(), "Сохранено", Toast.LENGTH_SHORT).show()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}