package com.hfad.zakovatuz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hfad.zakovatuz.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
// All questions must have four answers.  We'd want these to contain references to string
// resources so we could internationalize. (or better yet, not define the questions in code...)
    val questions: MutableList<Question> = mutableListOf(
        Question(text = "Kufa shahrini qurgan sahobiy kim?",
            answers = listOf("Sa’d ibn Abu Vaqqos", "Xolid ibn Valid", "Xolid ibn Valid", "Xolid ibn Valid" )),
        Question(text = "Bir ulug’ sahobiy shahodat kalimasini keltirganlarida Rasululloh s.a.v: 'Sening aqlingni ko’rib ,buaql faqat yahshilikka olib boradi, deb umid qilgan edim', deganlar. Rasululloh s.a.v. bu muborak lafzlarini qaysi sahobiyga qarata aytganlar?",
            answers = listOf("Xolid ibn Valid", "Xolid ibn Valid", "Xolid ibn Valid", "Xolid ibn Valid" )),
    )

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    var questionIndex = 0
    var numQuestions = 1
    private var incorrectGuesses = ""
    private var incorrectJavoblar = 0
    private var correctJavoblar = 0
    private var name = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        var name = GameFragmentArgs.fromBundle(requireArguments()).name
        randomizeQuestions()

        binding.submitButton.setOnClickListener {
            if (correctGuess() || incorrectGuess()) {
                if (good() && bad()) {
//                    view.findNavController().navigate(
//                        GameFragmentDirections.actionOyinFragmentToNatijaFragment(
//                            numQuestions, incorrectJavoblar, correctJavoblar, name
//                        )
//                    )
                } else if (bad()) {
//                    view.findNavController().navigate(
//                        GameFragmentDirections.actionOyinFragmentToBadNatijaFragment(
//                            numQuestions,
//                            incorrectJavoblar,
//                            correctJavoblar,
//                            incorrectGuesses,
//                            name
//                        )
//                    )
                }
            }
        }
        return view
    }

    private fun good(): Boolean = incorrectGuesses.isEmpty()
    private fun bad(): Boolean = questionIndex == numQuestions

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        questionIndex ++
    }

    private fun correctGuess(): Boolean {
        val checkedId = binding.questionRadioGroup.checkedRadioButtonId
        if (-1 != checkedId) {
            var answerIndex = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton -> answerIndex = 1
                R.id.thirdAnswerRadioButton -> answerIndex = 2
                R.id.fourthAnswerRadioButton -> answerIndex = 3
            }
            if (answers[answerIndex] == currentQuestion.answers[0]) {
                questionIndex++
                correctJavoblar++
                name = name
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                }
                return true // Guess was correct
            }
        }
        return false
    }

    fun incorrectGuess(): Boolean  {
        val checkedId = binding.questionRadioGroup.checkedRadioButtonId

        if ( -1 != checkedId) {
            var answerIndex = 0
            when (checkedId) {
                R.id.secondAnswerRadioButton -> answerIndex = 1
                R.id.thirdAnswerRadioButton -> answerIndex = 2
                R.id.fourthAnswerRadioButton -> answerIndex = 3
            }
            if (answers[answerIndex] != currentQuestion.answers[0]) {
                questionIndex ++
                name = name
                incorrectGuesses += "\n($questionIndex) ${currentQuestion.text} \n${currentQuestion.answers[0]} \n"
                incorrectJavoblar ++
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                }
                return true // Guess was incorrect
            }
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}