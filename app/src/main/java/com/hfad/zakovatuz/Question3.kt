package com.hfad.zakovatuz

class Question3(
    val text: String,
    val answers: List<String>
)
val question3s: MutableList<Question3> = mutableListOf(
    Question3(text = "1What is Android Jetpack?",
        answers = listOf("4", "tools", "documentation", "libraries")),
    Question3(text = "1Base class for Layout?",
        answers = listOf("4", "ViewSet", "ViewCollection", "ViewRoot")),
    Question3(text = "1Layout for complex Screens?",
        answers = listOf("4", "GridLayout", "LinearLayout", "FrameLayout")),
    Question3(text = "1Pushing structured data into a Layout?",
        answers = listOf("4", "Data Pushing", "Set Text", "OnClick")),
)