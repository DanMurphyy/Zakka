package com.hfad.zakovatuz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.hfad.zakovatuz.databinding.FragmentGameBinding
import com.hfad.zakovatuz.manager.GameManager
import com.hfad.zakovatuz.manager.GameManager.currentLevel
import com.hfad.zakovatuz.model.Question

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private var currentLevelQuestionList = mutableListOf<Question>()
    lateinit var currentQuestion: Question
    lateinit var currentQuestionShuffledAnswerList: List<String>

    private var currentQuestionIndex = 0
    private var numQuestions = 3

    private var incorrectGuesses = mutableListOf<String>()
    private var incorrectAnswerCount = 0
    private var correctAnswerCount = 0
    private var userName = ""
    private val currentLevelnumber: Int
        get() = currentLevel + 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        userName = GameFragmentArgs.fromBundle(requireArguments()).name
        binding.game = this
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.levelGame.text = "$currentLevelnumber - bosqich"
        setFragmentResultListener("nextLevelRequestKey") { _, _ -> }
        currentLevelQuestionList.clear()
        currentLevelQuestionList.addAll(GameManager.getCurrentLevelQuestion())
        randomizeQuestions()
        questionProgress()

        binding.submitButton.setOnClickListener {
            handleGuess()
            questionProgress()
        }
    }

    private fun handleGuess() {
        if (correctGuess() || incorrectGuess()) {
            if (good() && bad()) {
                openSuccessScreen()
            } else if (bad()) {
                openFailureScreen()
            }
        }
    }

    private fun randomizeQuestions() {
        currentLevelQuestionList.shuffle()
        currentQuestionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = currentLevelQuestionList[currentQuestionIndex]
        // Randomize the answers into a copy of the array
        currentQuestionShuffledAnswerList = currentQuestion.answers.toMutableList().shuffled()
    }

    private fun questionProgress() {
        var humanReadableNumber = currentQuestionIndex + 1
        if (humanReadableNumber == 11) {
            humanReadableNumber = 10
        }
        binding.questionN.text = "Savol: $humanReadableNumber / $numQuestions"
    }

    private fun correctGuess(): Boolean {
        val checkedId = binding.questionRadioGroup.checkedRadioButtonId
        val isOptionSelected = checkedId != -1
        if (isOptionSelected.not()) return false

        val answerIndex = when (checkedId) {
            R.id.firstAnswerRadioButton -> 0
            R.id.secondAnswerRadioButton -> 1
            R.id.thirdAnswerRadioButton -> 2
            R.id.fourthAnswerRadioButton -> 3
            else -> 0
        }

        val theCorrectOption = currentQuestion.answers.first()
        val userSelectedOption = currentQuestionShuffledAnswerList[answerIndex]
        val isUserSelectionCorrect = userSelectedOption == theCorrectOption
        if (isUserSelectionCorrect) {
            currentQuestionIndex++
            correctAnswerCount++
            // Advance to the next question

            val hasNextQuestion = currentQuestionIndex < currentLevelQuestionList.size
            if (hasNextQuestion) {
                setQuestion()
                binding.invalidateAll()
            }
            return true // Guess was correct
        }
        return false
    }

    private fun incorrectGuess(): Boolean {
        val checkedId = binding.questionRadioGroup.checkedRadioButtonId
        val isOptionSelected = checkedId != -1
        if (isOptionSelected.not()) return false

        val selectedAnswerIndex = when (checkedId) {
            R.id.firstAnswerRadioButton -> 0
            R.id.secondAnswerRadioButton -> 1
            R.id.thirdAnswerRadioButton -> 2
            R.id.fourthAnswerRadioButton -> 3
            else -> 0
        }

        val theCorrectOption = currentQuestion.answers.first()
        val userSelectedOption = currentQuestionShuffledAnswerList[selectedAnswerIndex]
        val isUserSelectionIncorrect = userSelectedOption != theCorrectOption
        if (isUserSelectionIncorrect) {
            currentQuestionIndex++
            incorrectGuesses.add("\n($currentQuestionIndex) ${currentQuestion.text} \n${currentQuestion.answers[0]} \n")
            incorrectAnswerCount++

            // Advance to the next question

            val hasNextQuestion = currentQuestionIndex < currentLevelQuestionList.size
            if (hasNextQuestion) {
                setQuestion()
                binding.invalidateAll()
            }
            return true // Guess was incorrect
        }
        return false
    }


    private fun good(): Boolean = incorrectGuesses.isEmpty()

    private fun bad() = currentQuestionIndex == numQuestions

    private fun openSuccessScreen() {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToGoodResultFragment(
                numQuestions, incorrectAnswerCount, correctAnswerCount, userName, currentLevelnumber
            )
        )
        correctAnswerCount = 0
    }

    private fun openFailureScreen() {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToBadResultFragment(
                numQuestions,
                incorrectAnswerCount,
                correctAnswerCount,
                incorrectGuesses.toString(),
                userName,
                currentLevelnumber
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}