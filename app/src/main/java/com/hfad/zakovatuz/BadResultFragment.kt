package com.hfad.zakovatuz

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.hfad.zakovatuz.databinding.FragmentBadResultBinding
import java.io.File
import java.io.FileOutputStream

class BadResultFragment : Fragment() {
    private var _binding: FragmentBadResultBinding? = null
    private val binding get() = _binding!!
    private var mInterstitialAd: InterstitialAd? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBadResultBinding.inflate(inflater, container, false)

        val adRequest = AdRequest.Builder().build()
        binding.adView5.loadAd(adRequest)


        val adInRequest = AdRequest.Builder().build()

        InterstitialAd.load(requireContext(),
            "ca-app-pub-8558811277281829/1887293823",
            adInRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(TAG, "Ad was loaded")
                    mInterstitialAd = interstitialAd
                }
            })

        if (mInterstitialAd != null) {
            mInterstitialAd?.show(requireActivity())
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }

        val view = binding.root
        val numQuestions = BadResultFragmentArgs.fromBundle(requireArguments()).numQuestions
        val incorrectGuesses = BadResultFragmentArgs.fromBundle(requireArguments()).incorrectGuesses
        val inCorrectJavoblar =
            BadResultFragmentArgs.fromBundle(requireArguments()).inCorrectJavoblar
        val correctJavoblar = BadResultFragmentArgs.fromBundle(requireArguments()).correctJavoblar
        val name = BadResultFragmentArgs.fromBundle(requireArguments()).name
        val btnCustomDialog: Button = view.findViewById(R.id.wrong)
        val currentLevelIndex =
            BadResultFragmentArgs.fromBundle(requireArguments()).currentLevelIndex

        binding.wrongIntro.text =
            "!! Afsus $name !! \nSiz ZakovatUz o'yinini $currentLevelIndex -bosqichda yakunladingiz"
        binding.wrongResult.text =
            "Savollar miqdori : $numQuestions ta \nTo'g'ri javoblar    : $correctJavoblar ta \nXato javoblar      : $inCorrectJavoblar ta"
        binding.restart.setOnClickListener {
            view.findNavController()
                .navigate(BadResultFragmentDirections.actionBadResultFragmentToEnterFragment(name))
        }
        btnCustomDialog.setOnClickListener {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(requireActivity())
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }
            customDialogFunction(incorrectGuesses)
        }

        binding.share.setOnClickListener {
            generateLayoutPhoto()
            shareLayoutPhoto(" Ilovani yuklab oling \nhttps://play.google.com/store/apps/details?id=com.hfad.zakovatuz")
        }

        return view
    }

    private fun customDialogFunction(incorrectGuesses: String) {
        val customDialog = Dialog(requireContext())
        customDialog.setContentView(R.layout.wrong_answers)
        val textXato = customDialog.findViewById<TextView>(R.id.list)
        textXato.text = incorrectGuesses.substring(1, incorrectGuesses.length - 1)
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun generateLayoutPhoto(): Bitmap {
        // Find the specific view that you want to share
        val viewToShare = binding.root

        // Generate a bitmap of the view
        val bitmap =
            Bitmap.createBitmap(binding.wrongGeneral.width, binding.wrongGeneral.height, Bitmap.Config.ARGB_8888)
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
        shareIntent.putExtra(Intent.EXTRA_STREAM,
            FileProvider.getUriForFile(requireContext(),
                BuildConfig.APPLICATION_ID + ".provider",
                file))
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