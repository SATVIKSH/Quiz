package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username=intent.getStringExtra(Constants.username)
        val score=intent.getIntExtra(Constants.score,0)
        val name=findViewById<TextView>(R.id.tv_name)
        name.setText(username)
        val result=findViewById<TextView>(R.id.tv_score)
        result.setText("You Scored $score out of 9")
        val btn=findViewById<Button>(R.id.btn_finish)
        btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}