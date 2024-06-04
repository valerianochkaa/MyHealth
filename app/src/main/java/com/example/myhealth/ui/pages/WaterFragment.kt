package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentWaterBinding
import com.example.myhealth.ui.adapters.WaterAdapter
import com.example.myhealth.ui.components.DialogWater
import com.example.myhealth.ui.data.WaterDate
import java.util.ArrayList

class WaterFragment : Fragment(R.layout.fragment_water) {
    private var _binding: FragmentWaterBinding? = null
    private val binding get() = _binding!!
    private var waterList = arrayListOf<WaterDate>()
    private lateinit var adapter: WaterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigation Component
        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.water_to_diary)
        }
        // Dialog
        binding.btnGoal.setOnClickListener {
            DialogWater(
                onSubmitClickListener = { quantity ->
                    Toast.makeText(requireContext(), "1", Toast.LENGTH_SHORT).show()
                }
            ).show(parentFragmentManager, "dialog")
        }
        // Recycler View
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = WaterAdapter(waterList, context)
        binding.recyclerView.adapter = adapter
    }
    private fun addDataToList() {
        waterList.add(WaterDate(50,"01.01.2024"))
        waterList.add(WaterDate(100,"01.01.2024"))
    }
}