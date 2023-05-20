package com.hfad.zakovatuz

class Question4(
    val text: String,
    val answers: List<String>
)
val question4s: MutableList<Question4> = mutableListOf(
    Question4(text = "1What is Android Jetpack?",
        answers = listOf("5", "tools", "documentation", "libraries")),
    Question4(text = "1Base class for Layout?",
        answers = listOf("5", "ViewSet", "ViewCollection", "ViewRoot")),
    Question4(text = "1Layout for complex Screens?",
        answers = listOf("5", "GridLayout", "LinearLayout", "FrameLayout")),
    Question4(text = "1Pushing structured data into a Layout?",
        answers = listOf("5", "Data Pushing", "Set Text", "OnClick")),
)