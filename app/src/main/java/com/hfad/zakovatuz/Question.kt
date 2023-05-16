package com.hfad.zakovatuz

data class Question(
    val text: String,
    val answers: List<String>)

// The first answer is the correct one.  We randomize the answers before showing the text.
// All questions must have four answers.  We'd want these to contain references to string
// resources so we could internationalize. (or better yet, not define the questions in code...)
val questions: MutableList<Question> = mutableListOf(
    Question(text = "What is Android Jetpack?",
        answers = listOf("1", "tools", "documentation", "libraries")),
    Question(text = "Base class for Layout?",
        answers = listOf("1", "ViewSet", "ViewCollection", "ViewRoot")),
    Question(text = "Layout for complex Screens?",
        answers = listOf("1", "GridLayout", "LinearLayout", "FrameLayout")),
    Question(text = "Pushing structured data into a Layout?",
        answers = listOf("1", "Data Pushing", "Set Text", "OnClick")),
    Question(text = "Inflate layout in fragments?",
        answers = listOf("1", "onViewCreated", "onCreateLayout", "onInflateLayout")),
    Question(text = "Build system for Android?",
        answers = listOf("1", "Graddle", "Grodle", "Groyle")),
    Question(text = "Android vector format?",
        answers = listOf("1", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
    Question(text = "Android Navigation Component?",
        answers = listOf("1", "NavCentral", "NavMaster", "NavSwitcher")),
    Question(text = "Registers app with launcher?",
        answers = listOf("1", "app-registry", "launcher-registry", "app-launcher")),
    Question(text = "Mark a layout for Data Binding?",
        answers = listOf("1", "<binding>", "<data-binding>", "<dbinding>"))
)



