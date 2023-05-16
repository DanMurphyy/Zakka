package com.hfad.zakovatuz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.zakovatuz.databinding.FragmentBadResultBinding
import com.hfad.zakovatuz.databinding.FragmentGoodResultBinding


class GoodResultFragment : Fragment() {

    private var _binding: FragmentGoodResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentGoodResultBinding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }

}