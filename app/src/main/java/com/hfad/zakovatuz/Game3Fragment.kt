package com.hfad.zakovatuz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hfad.zakovatuz.databinding.FragmentGame1Binding
import com.hfad.zakovatuz.databinding.FragmentGame3Binding

class Game3Fragment : Fragment() {

    private var _binding: FragmentGame3Binding? = null
    private val binding get() = _binding!!
    lateinit var currentQuestion: Question3
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var numQuestions = 10
    private var incorrectGuesses = ""
    private var incorrectJavoblar = 0
    private var correctJavoblar = 0
    private var name = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGame3Binding.inflate(inflater, container, false)
        val view = binding.root
        name = Game3FragmentArgs.fromBundle(requireArguments()).name
        binding.game3 = this

        randomizeQuestions()
        questionProgress()
        binding.submitButton3.setOnClickListener {
            if (correctGuess() || incorrectGuess()) {
                if (good() && bad()) {
                    println("hoop004")
                    view.findNavController().navigate(
                        Game3FragmentDirections.actionGame3FragmentToGoodResult3Fragment(
                            numQuestions, incorrectJavoblar, correctJavoblar, name
                        )
                    )
                } else if (bad()) {
                    println("hoop005")
                    view.findNavController().navigate(
                        Game3FragmentDirections.actionGame3FragmentToBadResult3Fragment(
                            numQuestions,
                            incorrectJavoblar,
                            correctJavoblar,
                            incorrectGuesses,
                            name
                        )
                    )
                }
            }
            questionProgress()
        }

        return view
    }

    private fun correctGuess(): Boolean {
        val checkedId = binding.questionRadioGroup3.checkedRadioButtonId
        if (-1 != checkedId) {
            var answerIndex = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton3 -> answerIndex = 1
                R.id.thirdAnswerRadioButton3 -> answerIndex = 2
                R.id.fourthAnswerRadioButton3 -> answerIndex = 3
            }
            if (answers[answerIndex] == currentQuestion.answers[0]) {
                questionIndex++
                correctJavoblar++
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = question3s[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                }
                return true // Guess was correct
            }
        }
        return false
    }

    private fun incorrectGuess(): Boolean {
        val checkedId = binding.questionRadioGroup3.checkedRadioButtonId

        if (-1 != checkedId) {
            var answerIndex = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton3 -> answerIndex = 1
                R.id.thirdAnswerRadioButton3 -> answerIndex = 2
                R.id.fourthAnswerRadioButton3 -> answerIndex = 3
            }
            if (answers[answerIndex] != currentQuestion.answers[0]) {
                questionIndex++
                incorrectGuesses += "\n($questionIndex) ${currentQuestion.text} \n${currentQuestion.answers[0]} \n"
                incorrectJavoblar++
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = question3s[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                }
                return true // Guess was incorrect

            }
        }
        return false
    }
    private fun good(): Boolean = incorrectGuesses.isEmpty()

    private fun bad() = questionIndex == numQuestions

    private fun randomizeQuestions() {
        question3s.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = question3s[questionIndex]
        // Randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // Shuffle the answers
        answers.shuffle()
    }

    private fun questionProgress() {
        val num = questionIndex
        val list = progress(num.toString())
        binding.questionN3.text = "Savol: ${list.first()} / $numQuestions"
    }
    fun progress(num:String) : List<String>{
        return when(num) {
            "0" -> listOf("1")
            "1" -> listOf("2")
            "2" -> listOf("3")
            "3" -> listOf("4")
            "4" -> listOf("5")
            "5" -> listOf("6")
            "6" -> listOf("7")
            "7" -> listOf("8")
            "8" -> listOf("9")
            "9" -> listOf("10")
            "10" -> listOf("10")
            else -> listOf("10")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}