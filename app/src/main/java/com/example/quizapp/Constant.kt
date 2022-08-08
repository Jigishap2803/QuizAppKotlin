package com.example.quizapp

object Constant {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "Correct_answers"


    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val ques1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.argentina,
            "Argentina",
            "Armenia",
            "Austria",
            "Australia",
            1
        )
        questionList.add(ques1)

        val ques2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.australia,
            "Argentina",
            "New Zealand",
            "Austria",
            "Australia",
            4
        )
        questionList.add(ques2)

        val ques3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.austria,
            "Germany",
            "Armenia",
            "Austria",
            "Australia",
            3
        )
        questionList.add(ques3)

        val ques4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.belgium,
            "Argentina",
            "Belgium",
            "Austria",
            "Australia",
            2
        )
        questionList.add(ques4)

        val ques5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.brazil,
            "Brazil",
            "Ireland",
            "Sri Lanka",
            "India",
            1
        )
        questionList.add(ques5)

        val ques6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.denmark,
            "Germany",
            "Hungary",
            "New Zealand",
            "Denmark",
            4
        )
        questionList.add(ques6)

        val ques7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.fiji,
            "Argentina",
            "Fiji",
            "United States of America",
            "Tuvalu",
            2
        )
        questionList.add(ques7)

        val ques8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.germany,
            "Germany",
            "Tuvalu",
            "Hungary",
            "Kuwait",
            1
        )
        questionList.add(ques8)

        val ques9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.india,
            "Kuwait",
            "China",
            "India",
            "Pakistan",
            3
        )
        questionList.add(ques9)

        val ques10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.kuwait,
            "Argentina",
            "Germany",
            "Austria",
            "Kuwait",
            4
        )
        questionList.add(ques10)

        val ques11 = Question(
            11,
            "What country does this flag belong to?",
            R.drawable.new_zealand,
            "India",
            "New Zealand",
            "Tuvalu",
            "Australia",
            2
        )
        questionList.add(ques11)

        return questionList
    }


}