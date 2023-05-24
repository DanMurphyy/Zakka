package com.hfad.zakovatuz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hfad.zakovatuz.databinding.FragmentGame1Binding
import com.hfad.zakovatuz.databinding.FragmentGame4Binding

class Game4Fragment : Fragment() {

    private var _binding: FragmentGame4Binding? = null
    private val binding get() = _binding!!
    lateinit var currentQuestion: Question4
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var numQuestions = 3
    private var incorrectGuesses = ""
    private var incorrectJavoblar = 0
    private var correctJavoblar = 0
    private var name = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGame4Binding.inflate(inflater, container, false)
        val view = binding.root
        name = Game4FragmentArgs.fromBundle(requireArguments()).name
        binding.game4 = this

        randomizeQuestions()
        questionProgress()
        binding.submitButton4.setOnClickListener {
            if (correctGuess() || incorrectGuess()) {
                if (good() && bad()) {
                    println("hoop004")
                    view.findNavController().navigate(
                        Game4FragmentDirections.actionGame4FragmentToGoodResult4Fragment(
                            numQuestions, incorrectJavoblar, correctJavoblar, name
                        )
                    )
                } else if (bad()) {
                    println("hoop005")
                    view.findNavController().navigate(
                        Game4FragmentDirections.actionGame4FragmentToBadResult4Fragment(
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
        val checkedId = binding.questionRadioGroup4.checkedRadioButtonId
        if (-1 != checkedId) {
            var answerIndex = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton4 -> answerIndex = 1
                R.id.thirdAnswerRadioButton4 -> answerIndex = 2
                R.id.fourthAnswerRadioButton4 -> answerIndex = 3
            }
            if (answers[answerIndex] == currentQuestion.answers[0]) {
                questionIndex++
                correctJavoblar++
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = question4s[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                }
                return true // Guess was correct
            }
        }
        return false
    }

    private fun incorrectGuess(): Boolean {
        val checkedId = binding.questionRadioGroup4.checkedRadioButtonId

        if (-1 != checkedId) {
            var answerIndex = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton4 -> answerIndex = 1
                R.id.thirdAnswerRadioButton4 -> answerIndex = 2
                R.id.fourthAnswerRadioButton4 -> answerIndex = 3
            }
            if (answers[answerIndex] != currentQuestion.answers[0]) {
                questionIndex++
                incorrectGuesses += "\n($questionIndex) ${currentQuestion.text} \n${currentQuestion.answers[0]} \n"
                incorrectJavoblar++
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = question4s[questionIndex]
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
        question4s.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = question4s[questionIndex]
        // Randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // Shuffle the answers
        answers.shuffle()
    }

    private fun questionProgress() {
        val num = questionIndex
        val list = progress(num.toString())
        binding.questionN4.text = "Savol: ${list.first()} / $numQuestions"
    }
    fun progress(num:String) : List<String>{
        return when(num) {
            "0" -> listOf("1")
            "1" -> listOf("2")
            "2" -> listOf("3")
            else -> listOf("3")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}