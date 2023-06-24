package com.hfad.zakovatuz.manager

import com.hfad.zakovatuz.model.Question

object GameManager {
    var currentLevel = 0

    fun goToNextLevel() {
        currentLevel++
    }

    fun resetGame(){
        currentLevel=0
    }

    fun getCurrentLevelQuestion(): List<Question> {
        when (currentLevel) {
            0 -> return QuestionManager.levelZeroQuestions
            1 -> return QuestionManager.level1Questions
            2 -> return QuestionManager.level2Questions
            3 -> return QuestionManager.level3Questions
            4 -> return QuestionManager.level4Question
            else -> return emptyList()
        }
    }
}