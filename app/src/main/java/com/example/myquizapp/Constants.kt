package com.example.myquizapp

object Constants {
    var username:String="username"
    var score:String="0"
    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val q1=Question(1,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_argentina, optionOne = "INDIA", optionTwo = "PROTUGAL", optionThree = "ARGENTINA", optionFour = "FRANCE", correctAnswer = 3)
        val q2=Question(2,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_belgium, optionOne = "BELGIUM", optionTwo = "KUWAIT", optionThree = "AUSTRIA", optionFour = "FRANCE", correctAnswer = 1)
        val q3=Question(3,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_brazil, optionOne = "BELGIUM", optionTwo = "KUWAIT", optionThree = "AUSTRIA", optionFour = "BRAZIL", correctAnswer = 4)
        val q4=Question(1,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_denmark, optionOne = "BELGIUM", optionTwo = "DENMARK", optionThree = "SWITZERLAND", optionFour = "IRELAND", correctAnswer = 2)
        val q5=Question(1,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_germany, optionOne = "GERMANY", optionTwo = "DENMARK", optionThree = "KUWAIT", optionFour = "IRELAND", correctAnswer = 1)
        val q6=Question(1,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_india, optionOne = "BELGIUM", optionTwo = "DENMARK", optionThree = "SWITZERLAND", optionFour = "NONE OF THE ABOVE", correctAnswer = 4)
        val q7=Question(1,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_kuwait, optionOne = "YEMEN", optionTwo = "LEBANON", optionThree = "KUWAIT", optionFour = "NONE OF THE ABOVE", correctAnswer = 3)
        val q8=Question(1,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_germany, optionOne = "AUSTRALIA", optionTwo = "DENMARK", optionThree = "SWITZERLAND", optionFour = "NONE OF THE ABOVE", correctAnswer = 4)
        val q9=Question(1,"WHAT COUNTRY DOES THIS FLAG BELONG TO",R.drawable.ic_flag_of_australia, optionOne = "AUSTRALIA", optionTwo = "DENMARK", optionThree = "SWITZERLAND", optionFour = "IRELAND", correctAnswer = 1)
        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
return questionList
    }
}