package com.hfad.zakovatuz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.hfad.zakovatuz.databinding.FragmentGoodResultBinding
import com.hfad.zakovatuz.manager.GameManager
import java.io.File
import java.io.FileOutputStream


class GoodResultFragment : Fragment() {

    private var _binding: FragmentGoodResultBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGoodResultBinding.inflate(inflater, container, false)

        val view = binding.root

        val args = GoodResultFragmentArgs.fromBundle(requireArguments())

        val numQuestions = args.numQuestions
        val inCorrectJavoblar = args.inCorrectJavoblar
        val correctJavoblar = args.correctJavoblar
        val name = args.name
        val currentLevelIndex = args.currentLevelIndex
        binding.levelNumber.text = "$currentLevelIndex bosqich yakunlandi!! "
        binding.goodIntro.text = "!! Tabriklaymiz $name !! \n Siz $currentLevelIndex -bosqichni muvaffaqiyatli bajardingiz!"
        binding.goodResults.text = "Savollar miqdori : $numQuestions ta \nTo'g'ri javoblar    : $correctJavoblar ta \nXato javoblar      : $inCorrectJavoblar ta"
        binding.restartm.setOnClickListener {
            view.findNavController().navigate(R.id.action_goodResultFragment_to_enterFragment)
        }
        binding.sharem.setOnClickListener{
            generateLayoutPhoto()
            shareLayoutPhoto(" Ilovani yuklab olin \nhttps://telegram.me/joinchat/SDdS2FAiH5e4grs5")
        }

        binding.next.setOnClickListener {
            setFragmentResult("nextLevelRequestKey", bundleOf())
            view?.findNavController()?.navigateUp()
            GameManager.goToNextLevel()
        }

        return view
    }

    private fun generateLayoutPhoto(): Bitmap {
        // Find the specific view that you want to share
        val viewToShare = binding.root

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