package com.hfad.zakovatuz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.zakovatuz.databinding.FragmentBadResultBinding

class BadResultFragment : Fragment() {
    private var _binding: FragmentBadResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBadResultBinding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }
}