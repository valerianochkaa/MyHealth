package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentMedicinesBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MedicinesFragment : Fragment(R.layout.fragment_medicines) {
    private var _binding: FragmentMedicinesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the ViewPager with the sections adapter.
        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity())
        binding.viewPager.adapter = sectionsPagerAdapter

        // Connect TabLayout with ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.medicines_tab1)
                1 -> tab.text = getString(R.string.medicines_tab2)
            }
        }.attach()
    }

    private inner class SectionsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ActiveMedicinesFragment()
                1 -> CompletedMedicinesFragment()
                else -> throw IllegalStateException("Unexpected position $position")
            }
        }

        override fun getItemCount(): Int {
            return 2 // We have two tabs
        }
    }
}
