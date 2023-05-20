package com.hfad.zakovatuz

class Question1 (
    val text: String,
    val answers: List<String>)

val question1s: MutableList<Question1> = mutableListOf(
    Question1(text = "1What is Android Jetpack?",
    answers = listOf("2", "tools", "documentation", "libraries")),
    Question1(text = "1Base class for Layout?",
    answers = listOf("2", "ViewSet", "ViewCollection", "ViewRoot")),
    Question1(text = "1Layout for complex Screens?",
    answers = listOf("2", "GridLayout", "LinearLayout", "FrameLayout")),
    Question1(text = "1Pushing structured data into a Layout?",
    answers = listOf("2", "Data Pushing", "Set Text", "OnClick")),
)