package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentAddMedicines2Binding
import com.example.myhealth.ui.adapters.MedicinesAdapter
import com.example.myhealth.ui.data.MedicinesData
import java.util.ArrayList
import java.util.Locale

class AddMedicines2 : Fragment(R.layout.fragment_add_medicines2) {
    private var _binding: FragmentAddMedicines2Binding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private var medicinesList = ArrayList<MedicinesData>()
    private lateinit var adapter: MedicinesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddMedicines2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigation Component
        navController = findNavController()
        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.addMedicines2_to_addMedicines1)
        }

        // Recycler View
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = MedicinesAdapter(medicinesList, context, navController)
        binding.recyclerView.adapter = adapter

        // Search View
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun addDataToList() {
        medicinesList.add(MedicinesData("Аторвастатин","Гиполипидемическое средство для снижения уровня холестерина","Аторвастатин",
            "Таблетки","Аторвастатин, вспомогательные вещества (лактоза, целлюлоза, стеарат магния)",
            "Гиперхолестеринемия, профилактика сердечно-сосудистых заболеваний","Заболевания печени в активной фазе, беременность и лактация"))
        medicinesList.add(MedicinesData("Лизиноприл","Ингибитор АПФ для лечения артериальной гипертензии","Лизиноприл",
            "Таблетки","Лизиноприл, вспомогательные вещества (лактоза, крахмал, стеарат магния)",
            "Артериальная гипертензия, хроническая сердечная недостаточность","Аллергия на лизиноприл, ангионевротический отек в анамнезе"))
        medicinesList.add(MedicinesData("Метформин","Гипогликемическое средство для лечения сахарного диабета 2 типа","Метформин",
            "Таблетки","Метформин, вспомогательные вещества (целлюлоза, повидон, стеарат магния)",
            "Сахарный диабет 2 типа","Почечная недостаточность, хронические заболевания печени, лактоацидоз"))
        medicinesList.add(MedicinesData("Амлодипин","Антигипертензивное средство","Амлодипин",
            "Таблетки","Амлодипин, вспомогательные вещества (целлюлоза, крахмал, стеарат магния)",
            "Артериальная гипертензия, стенокардия","Аллергия на амлодипин, кардиогенный шок, тяжелая гипотензия"))
        medicinesList.add(MedicinesData("Ибупрофен","Нестероидное противовоспалительное средство","Ибупрофен",
            "Таблетки","Ибупрофен, вспомогательные вещества (лактоза, крахмал, стеарат магния)",
            "Воспалительные заболевания, боль различной этиологии, лихорадка","Язвенная болезнь желудка и двенадцатиперстной кишки, бронхиальная астма, аллергия на ибупрофен"))
        medicinesList.add(MedicinesData("Бисопролол","Бета-адреноблокатор для лечения артериальной гипертензии и сердечной недостаточности","Бисопролол",
            "Таблетки","Бисопролол, вспомогательные вещества (целлюлоза, крахмал, стеарат магния",
            "Артериальная гипертензия, хроническая сердечная недостаточность, стенокардия","Кардиогенный шок, выраженная брадикардия, тяжелая форма бронхиальной астмы"))
        medicinesList.add(MedicinesData("Эналаприл","Ингибитор АПФ для лечения артериальной гипертензии и сердечной недостаточности","Эналаприл",
            "Таблетки","Эналаприл, вспомогательные вещества (лактоза, крахмал, стеарат магния)",
            "Артериальная гипертензия, хроническая сердечная недостаточность","Аллергия на эналаприл, ангионевротический отек в анамнезе"))
        medicinesList.add(MedicinesData("Сорбифер Дурулес","Препарат для лечения и профилактики железодефицитной анемии","Железа сульфат, аскорбиновая кислота.",
            "Таблетки","Одна таблетка содержит 320 мг железа сульфата и 60 мг аскорбиновой кислоты",
            "Лечение и профилактика железодефицитной анемии, обусловленной повышенной потребностью в железе, недостаточным поступлением железа с пищей, нарушением всасывания железа в кишечнике",
            "Гемохроматоз, гемосидероз, апластическая и гемолитическая анемия, язвенная болезнь желудка и двенадцатиперстной кишки в стадии обострения, детский возраст до 12 лет, повышенная чувствительность к компонентам препарата"))
        medicinesList.add(MedicinesData("Л-тироксин","Препарат для лечения заболеваний щитовидной железы","Левотироксин натрия",
            "Таблетки","Одна таблетка содержит 50 мкг или 100 мкг левотироксина натрия",
            "Гипотиреоз, эутиреоидный зоб, профилактика рецидива зоба после резекции щитовидной железы, рак щитовидной железы",
            "Некомпенсированная надпочечниковая недостаточность, острый инфаркт миокарда, острый миокардит, повышенная чувствительность к компонентам препарата"))
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<MedicinesData>()
            for (i in medicinesList) {
                if (i.name.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))) {
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
                binding.tvNoResults.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            } else {
                binding.tvNoResults.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                adapter.setFilteredList(filteredList)
            }
        }
    }
}
