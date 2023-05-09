package com.hfad.zakovatuz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.hfad.zakovatuz.databinding.FragmentEnterBinding

class EnterFragment : Fragment() {
    private var _binding:  FragmentEnterBinding? = null
    private val binding get() = _binding!!
    var name = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding = FragmentEnterBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.editSubmit.setOnClickListener {
            enterName(binding.editName.text.toString()) }
        return view
    }
    private fun enterName(name: String) {
        if (name.isEmpty()) {
            Toast.makeText(requireActivity(), "Ism kiritilmadi", Toast.LENGTH_SHORT).show()
        } else {
            this.name = name
            val action = EnterFragmentDirections.actionEnterFragmentToGameFragment(name)
            view?.findNavController()?.navigate(action)
            binding.editName.text!!.clear() }}
}