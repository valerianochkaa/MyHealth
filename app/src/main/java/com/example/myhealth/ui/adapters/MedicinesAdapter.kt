package com.example.myhealth.ui.adapters

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.R
import com.example.myhealth.ui.data.MedicinesData


class MedicinesAdapter(var mList: List<MedicinesData>, private val context: Context?, private val navController: NavController) :
    RecyclerView.Adapter<MedicinesAdapter.MedicinesViewHolder>() {

    inner class MedicinesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.title)
        val btnInfo: ImageView = itemView.findViewById(R.id.btnInfo)
    }

    fun setFilteredList(mList: List<MedicinesData>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicinesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicines_search, parent, false)
        return MedicinesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicinesViewHolder, position: Int) {
        holder.name.text = mList[position].name
        holder.btnInfo.setOnClickListener {
            showDialog(mList[position])
        }
        holder.itemView.setOnClickListener {
            navController.navigate(R.id.addMedicines2_to_addMedicines3)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    private fun showDialog(medicineData: MedicinesData) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_instruction, null)
        val dialogBuilder = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(true)
        val dialog = dialogBuilder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val title: TextView = dialogView.findViewById(R.id.name)
        val description: TextView = dialogView.findViewById(R.id.description)
        val ingredients: TextView = dialogView.findViewById(R.id.ingredients)
        val releases: TextView = dialogView.findViewById(R.id.releases)
        val composition: TextView = dialogView.findViewById(R.id.composition)
        val indications: TextView = dialogView.findViewById(R.id.indications)
        val contraindications: TextView = dialogView.findViewById(R.id.contraindications)

        title.text = medicineData.name
        description.text = medicineData.description
        ingredients.text = medicineData.ingredients
        releases.text = medicineData.releases
        composition.text = medicineData.composition
        indications.text = medicineData.indications
        contraindications.text = medicineData.contraindications
        val btnClose: ImageView = dialogView.findViewById(R.id.btnClose)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}

