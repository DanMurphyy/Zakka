package com.hfad.zakovatuz

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.FileProvider
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.hfad.zakovatuz.databinding.FragmentGoodResultBinding
import com.hfad.zakovatuz.manager.GameManager
import java.io.File
import java.io.FileOutputStream


class GoodResultFragment : Fragment() {

    private var _binding: FragmentGoodResultBinding? = null
    private val binding get() = _binding!!
    private var mInterstitialAd: InterstitialAd? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGoodResultBinding.inflate(inflater, container, false)

        val adRequest = AdRequest.Builder().build()
        binding.adView4.loadAd(adRequest)

        val view = binding.root

        val args = GoodResultFragmentArgs.fromBundle(requireArguments())

        val numQuestions = args.numQuestions
        val inCorrectJavoblar = args.inCorrectJavoblar
        val correctJavoblar = args.correctJavoblar
        val name = args.name
        val currentLevelIndex = args.currentLevelIndex
        binding.levelNumber.text = "$currentLevelIndex bosqich yakunlandi!! "
        binding.goodIntro.text =
            "!! Tabriklaymiz $name !! \n Siz $currentLevelIndex -bosqichni muvaffaqiyatli bajardingiz!"
        binding.goodResults.text =
            "Savollar miqdori : $numQuestions ta \nTo'g'ri javoblar    : $correctJavoblar ta \nXato javoblar      : $inCorrectJavoblar ta"

        binding.levelNumberFinal.text = "$currentLevelIndex bosqich yakunlandi!! "
        binding.goodIntroFinal.text =
            "!! Tabriklaymiz $name !! \n Siz $currentLevelIndex -bosqichni muvaffaqiyatli bajardingiz!"
        binding.goodResultsFinal.text =
            "Savollar miqdori : $numQuestions ta \nTo'g'ri javoblar    : $correctJavoblar ta \nXato javoblar      : $inCorrectJavoblar ta"

        if (currentLevelIndex <= 4) {
            binding.goodResultsFinal.visibility = View.INVISIBLE
            binding.shareRestartFinal.visibility = View.INVISIBLE
            binding.finalOveral.visibility = View.INVISIBLE
            binding.prizeFinal.visibility = View.INVISIBLE
            binding.goodResultMain.visibility = View.VISIBLE
            binding.shareRestartMain.visibility = View.VISIBLE
        } else {
            binding.goodResultMain.visibility = View.INVISIBLE
            binding.shareRestartMain.visibility = View.INVISIBLE
            binding.goodResultsFinal.visibility = View.VISIBLE
            binding.shareRestartFinal.visibility = View.VISIBLE
            binding.finalOveral.visibility = View.VISIBLE
            binding.prizeFinal.visibility = View.VISIBLE

            gif()
            gif1()
        }

        val adInRequest = AdRequest.Builder().build()

        InterstitialAd.load(requireContext(),
            "ca-app-pub-8558811277281829/1887293823",
            adInRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(ContentValues.TAG, adError.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(ContentValues.TAG, "Ad was loaded")
                    mInterstitialAd = interstitialAd
                }
            })

        if (mInterstitialAd != null) {
            mInterstitialAd?.show(requireActivity())
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }

        binding.restartm.setOnClickListener {
            view.findNavController().navigate(R.id.action_goodResultFragment_to_enterFragment)
        }
        binding.restartfinal.setOnClickListener {
            view.findNavController().navigate(R.id.action_goodResultFragment_to_enterFragment)
        }
        binding.sharem.setOnClickListener {
            generateLayoutPhoto()
            shareLayoutPhoto(" Ilovani yuklab olin \nhttps://play.google.com/store/apps/details?id=com.hfad.zakovatuz")
        }
        binding.sharem4.setOnClickListener {
            generateLayoutPhoto()
            shareLayoutPhoto(" Ilovani yuklab olin \nhttps://play.google.com/store/apps/details?id=com.hfad.zakovatuz")
        }
        binding.next.setOnClickListener {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(requireActivity())
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }
            setFragmentResult("nextLevelRequestKey", bundleOf())
            view?.findNavController()?.navigateUp()
            GameManager.goToNextLevel()
        }


        return view
    }

    fun gif() {
        val gifImageView: ImageView = binding.gif
        Glide.with(this)
            .asGif()
            .load(R.drawable.fire) // Assuming "fire.gif" is the name of your animated GIF file
            .into(gifImageView)
    }

    fun gif1() {
        val gifImageView: ImageView = binding.gif1
        Glide.with(this)
            .asGif()
            .load(R.drawable.fire) // Assuming "fire.gif" is the name of your animated GIF file
            .into(gifImageView)
    }


    private fun generateLayoutPhoto(): Bitmap {
        // Find the specific view that you want to share
        val viewToShare = binding.root

        // Generate a bitmap of the view
        val bitmap =
            Bitmap.createBitmap(viewToShare.width, viewToShare.height, Bitmap.Config.ARGB_8888)
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