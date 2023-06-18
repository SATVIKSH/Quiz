package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val startButton: Button=findViewById(R.id.startButton)
        val editText: EditText=findViewById(R.id.editText)
        startButton.setOnClickListener {
            if(editText.text.isNotEmpty()) {
                val intent: Intent = Intent(this, QuizQuestions::class.java)
                intent.putExtra(Constants.username,editText.text.toString())
                startActivity(intent)
                finish()
            }
                else{
              Toast.makeText(this,"ENTER YOUR NAME",Toast.LENGTH_LONG).show()
                }

        }
    }
}