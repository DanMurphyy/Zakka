package com.hfad.zakovatuz

import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.FileProvider
import androidx.navigation.findNavController
import com.hfad.zakovatuz.databinding.FragmentBadResult1Binding
import com.hfad.zakovatuz.databinding.FragmentBadResultBinding
import java.io.File
import java.io.FileOutputStream

class BadResult1Fragment : Fragment() {
    private var _binding: FragmentBadResult1Binding? = null
    private val binding get() = _binding!!

    private var __binding = R.layout.xato_javoblar
    private lateinit var bitmap: Bitmap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBadResult1Binding.inflate(inflater, container, false)

        val view = binding.root
        var numQuestions = BadResult1FragmentArgs.fromBundle(requireArguments()).numQuestions
        var incorrectGuesses = BadResult1FragmentArgs.fromBundle(requireArguments()).incorrectGuesses
        var inCorrectJavoblar = BadResult1FragmentArgs.fromBundle(requireArguments()).inCorrectJavoblar
        var correctJavoblar = BadResult1FragmentArgs.fromBundle(requireArguments()).correctJavoblar
        var name = BadResult1FragmentArgs.fromBundle(requireArguments()).name
        val btnCustomDialog: Button = view.findViewById(R.id.wrong1)

        binding.tabrik1.text = "!! Afsus $name !! \nSiz ZakovatUz oyinini 2chi bosqichda yakunladingiz"
        binding.natijalar1.text = "Savollar miqdori : $numQuestions ta \nTo'gri javoblar     : $correctJavoblar ta \nXato javoblar      : $inCorrectJavoblar ta"
        binding.restart1.setOnClickListener {
            view.findNavController().navigate(R.id.action_badResult1Fragment_to_enterFragment)
        }
        btnCustomDialog.setOnClickListener {
            customDialogFunction(incorrectGuesses)
        }
        binding.share1.setOnClickListener{
            generateLayoutPhoto()
            shareLayoutPhoto(" Ilovani yuklab olin \nhttps://telegram.me/joinchat/SDdS2FAiH5e4grs5")
        }

        return view
    }

    private fun customDialogFunction(incorrectGuesses: String) {
        val customDialog = Dialog(requireContext())
        customDialog.setContentView(R.layout.xato_javoblar)
        val textXato = customDialog.findViewById<TextView>(R.id.royhat)
        textXato.text = incorrectGuesses
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun generateLayoutPhoto(): Bitmap {
        // Find the specific view that you want to share
        val viewToShare = binding.umimiyNatija1

        // Generate a bitmap of the view
        val bitmap = Bitmap.createBitmap(viewToShare.width, viewToShare.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        viewToShare.draw(canvas)

        return bitmap
    }

    private fun shareLayoutPhoto(caption: String) {
        // Generate a bitmap of the specific view
        val bitmap = generateLayoutPhoto()

        // Save the bitmap to a temporary file
        val file = File(requireContext().cacheDir, "layout_image.jpg")
        val stream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream)
        stream.close()

        // Create a share intent for the temporary file and the caption
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/jpeg"
        shareIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(requireContext(), BuildConfig.APPLICATION_ID + ".provider", file))
        shareIntent.putExtra(Intent.EXTRA_TEXT, caption)
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        // Show the share dialog
        startActivity(Intent.createChooser(shareIntent, "Share layout photo with caption"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}