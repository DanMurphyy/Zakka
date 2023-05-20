package com.hfad.zakovatuz

class Question2 (
    val text: String,
    val answers: List<String>)
val question2s: MutableList<Question2> = mutableListOf(
    Question2(text = "1What is Android Jetpack?",
        answers = listOf("3", "tools", "documentation", "libraries")),
    Question2(text = "1Base class for Layout?",
        answers = listOf("3", "ViewSet", "ViewCollection", "ViewRoot")),
    Question2(text = "1Layout for complex Screens?",
        answers = listOf("3", "GridLayout", "LinearLayout", "FrameLayout")),
    Question2(text = "1Pushing structured data into a Layout?",
        answers = listOf("3", "Data Pushing", "Set Text", "OnClick"))
)