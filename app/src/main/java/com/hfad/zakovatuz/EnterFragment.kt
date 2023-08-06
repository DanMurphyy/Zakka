package com.hfad.zakovatuz

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.hfad.zakovatuz.databinding.FragmentEnterBinding
import com.hfad.zakovatuz.manager.GameManager


class EnterFragment : Fragment() {
    private var _binding: FragmentEnterBinding? = null
    private val binding get() = _binding!!
    var name = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEnterBinding.inflate(inflater, container, false)
        val view = binding.root

        setHasOptionsMenu(true)
        binding.editSubmit.setOnClickListener {
            enterName(binding.editName.text.toString())
        }
        GameManager.resetGame()

        val adRequest = AdRequest.Builder().build()
        binding.adView1.loadAd(adRequest)



        return view
    }

    private fun enterName(name: String) {

        if (name.isEmpty()) {
            Toast.makeText(requireActivity(), "Ism kiritilmadi", Toast.LENGTH_SHORT).show()
        } else {
            this.name = name
            val action = EnterFragmentDirections.actionEnterFragmentToGameFragment(name)
            view?.findNavController()?.navigate(action)
            binding.editName.text!!.clear()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.helpFragment -> findNavController().navigate(R.id.action_enterFragment_to_helpFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}