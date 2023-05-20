package com.hfad.zakovatuz

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.navigation.findNavController
import com.hfad.zakovatuz.databinding.FragmentBadResultBinding
import com.hfad.zakovatuz.databinding.FragmentGoodResult1Binding
import com.hfad.zakovatuz.databinding.FragmentGoodResultBinding
import java.io.File
import java.io.FileOutputStream


class GoodResult1Fragment : Fragment() {

    private var _binding: FragmentGoodResult1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentGoodResult1Binding.inflate(inflater, container, false)

        val view = binding.root

        var numQuestions = GoodResult1FragmentArgs.fromBundle(requireArguments()).numQuestions
        var inCorrectJavoblar = GoodResult1FragmentArgs.fromBundle(requireArguments()).inCorrectJavoblar
        var correctJavoblar = GoodResult1FragmentArgs.fromBundle(requireArguments()).correctJavoblar
        var name = GoodResult1FragmentArgs.fromBundle(requireArguments()).name

        binding.tabrikm1.text = "!! Tabriklaymiz $name !! \n Siz 2chi bosqichni muvaffaqiyatli bajardingiz "
        binding.natijalarm1.text = "Savollar miqdori : $numQuestions ta \nTo'gri javoblar     : $correctJavoblar ta \nXato javoblar      : $inCorrectJavoblar ta"
        binding.restartm1.setOnClickListener {
            view.findNavController().navigate(R.id.action_goodResult1Fragment_to_enterFragment)
        }
        binding.sharem1.setOnClickListener{
            generateLayoutPhoto()
            shareLayoutPhoto(" Ilovani yuklab olin \nhttps://telegram.me/joinchat/SDdS2FAiH5e4grs5")
        }

        binding.next1.setOnClickListener {
            view.findNavController().navigate(GoodResult1FragmentDirections.actionGoodResult1FragmentToGame2Fragment(name))
        }

        return view
    }


    private fun generateLayoutPhoto(): Bitmap {
        // Find the specific view that you want to share
        val viewToShare = binding.umimiyNatijam1

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