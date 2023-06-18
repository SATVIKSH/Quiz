package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestions : AppCompatActivity() ,View.OnClickListener{
    private var current=0
     private var questionList:ArrayList<Question>?=null
     private var selectedOption:Int=0
    private var tv_progressBar:TextView?=null
    private var progressBar:ProgressBar?=null
    private var iv_flag:ImageView?=null
    private var tv_question:TextView?=null
    private var tv_option_one:TextView?=null
    private var tv_option_two:TextView?=null
    private var tv_option_three:TextView?=null
    private var tv_option_four:TextView?=null
     private var correctAnswer:Int?=null
     private var btn: Button? =null
    private var username:String?=null
    private var score=0
    private var test=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        username=intent.getStringExtra(Constants.username)
        progressBar = findViewById(R.id.progressBar)
        tv_question = findViewById((R.id.tv_question))
        iv_flag = findViewById(R.id.iv_flag)
        tv_option_one = findViewById(R.id.tv_option_one)
        tv_option_two = findViewById(R.id.tv_option_two)
        tv_option_three = findViewById(R.id.tv_option_three)
        tv_option_four = findViewById(R.id.tv_option_four)
        btn=findViewById(R.id.btn_Submit)
        current=1
        setQuestion()
        tv_option_one?.setOnClickListener(this)
        tv_option_two?.setOnClickListener(this)
        tv_option_three?.setOnClickListener(this)
        tv_option_four?.setOnClickListener(this)
        btn?.setOnClickListener(this)
    }

     private fun setQuestion() {
         defaultOptionsView()
         questionList = Constants.getQuestions()


         var question: Question? = questionList!![current - 1]

         progressBar?.progress = current
         tv_progressBar = findViewById(R.id.tv_progressBar)
         tv_progressBar?.text = "$current" + "/" + "${progressBar!!.max}"

         tv_question?.text = question!!.question

         iv_flag?.setImageResource(question!!.image)

         tv_option_one?.text = question!!.optionOne

         tv_option_two?.text = question!!.optionTwo

         tv_option_three?.text = question!!.optionThree

         tv_option_four?.text = question!!.optionFour
         correctAnswer = question!!.correctAnswer



             btn?.text="SUBMIT"


     }
     private fun defaultOptionsView(){
         val options=ArrayList<TextView>()
        tv_option_one?.let { options.add(it) }
         tv_option_two?.let { options.add(it) }
         tv_option_three?.let { options.add(it) }
         tv_option_four?.let { options.add(it) }
         for(option in options)
         {
             option.setTextColor(Color.parseColor("#7A8089"))
             option.typeface= Typeface.DEFAULT
             option.background=ContextCompat.getDrawable(this,R.drawable.border)
         }
     }
    private fun selectedOptionView(tv:TextView,selectedNum:Int){
        defaultOptionsView()
         selectedOption=selectedNum
         tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_border)
    }
    private fun answerView(answer:Int,selectedDrawable:Int){
        when(answer){
            1->tv_option_one?.background=ContextCompat.getDrawable(this,selectedDrawable)
            2->tv_option_two?.background=ContextCompat.getDrawable(this,selectedDrawable)
            3->tv_option_three?.background=ContextCompat.getDrawable(this,selectedDrawable)
            4->tv_option_four?.background=ContextCompat.getDrawable(this,selectedDrawable)
        }
    }
    private fun buttonclicked(){

        if(selectedOption==0)
        {
            current++
            test=0
            if(current<=questionList!!.size)
            {setQuestion() }
             else
            {
              val intent= Intent(this,Result_Activity::class.java)
                 intent.putExtra(Constants.username,username)
                intent.putExtra(Constants.score,score)
                startActivity(intent)
                finish()
            }
        }
        else {

            if (selectedOption != correctAnswer) {
                answerView(selectedOption, R.drawable.incorrect_border)
            }
            if (selectedOption == correctAnswer) {
               score++
            }
            correctAnswer?.let { answerView(it, R.drawable.correct_border) }

            if (current >= questionList!!.size) {
                btn?.text = "FINISH"
                test=1
            } else {
                btn?.text = "GO TO NEXT QUESTION"
                test=1
            }
            selectedOption=0
        }

            }





     override fun onClick(view: View?) {
         when(view?.id) {
             R.id.tv_option_one -> {
                 tv_option_one?.let {if(test==0) {selectedOptionView(it, 1) }}
             }
             R.id.tv_option_two -> {
                 tv_option_two?.let {if(test==0) {selectedOptionView(it, 2) }}
             }
             R.id.tv_option_three -> {
                 tv_option_three?.let {if(test==0) {selectedOptionView(it, 3) }}
             }
             R.id.tv_option_four -> {
                 tv_option_four?.let {if(test==0) {selectedOptionView(it, 4) }}
             }
             R.id.btn_Submit -> {
                 buttonclicked()
             }
         }
         }
     }



