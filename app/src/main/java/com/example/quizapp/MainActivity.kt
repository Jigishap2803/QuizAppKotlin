package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var btn_start:Button? = null
    private var et_name:EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start=findViewById<Button>(R.id.btn_start)
        et_name=findViewById(R.id.et_name)

btn_start?.setOnClickListener{
if(et_name?.text.toString().isEmpty()){
    Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
} else {
    val intent = Intent(this, QuizQuestionsActivity::class.java)
    intent.putExtra(Constant.USER_NAME, et_name?.text.toString())
    startActivity(intent)
    finish()
}
}

    }
}