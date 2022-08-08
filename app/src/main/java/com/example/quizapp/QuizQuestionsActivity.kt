package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{
    var progressBar: ProgressBar? = null
    var tv_progress: TextView? = null
    var tv_question: TextView? = null
    var iv_image: ImageView? = null
    var tv_option_one:TextView? = null
    var tv_option_two:TextView? = null
    var tv_option_three:TextView? = null
    var tv_option_four:TextView? = null
    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String?=null
    private var btn_submit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        tv_progress = findViewById(R.id.tv_progress)
        tv_question = findViewById(R.id.tv_question)
        iv_image = findViewById(R.id.iv_image)
        tv_option_one = findViewById(R.id.tv_option_one)
        tv_option_two = findViewById(R.id.tv_option_two)
        tv_option_three = findViewById(R.id.tv_option_three)
        tv_option_four = findViewById(R.id.tv_option_four)
        btn_submit = findViewById(R.id.btn_submit)

        mUserName = intent.getStringExtra(Constant.USER_NAME)

        mQuestionList = Constant.getQuestions()
        setQuestion()

        tv_option_one!!.setOnClickListener(this)
        tv_option_two!!.setOnClickListener(this)
        tv_option_three!!.setOnClickListener(this)
        tv_option_four!!.setOnClickListener(this)
        btn_submit?.setOnClickListener(this)
    }

    fun setQuestion(){
        val question = mQuestionList?.get(mCurrentPosition - 1)

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size) {
            btn_submit?.text = "FINISH"
        } else {
            btn_submit?.text = "SUBMIT"
        }

        progressBar?.progress = mCurrentPosition
        tv_progress?.text ="$mCurrentPosition" + "/" + progressBar?.max

        tv_question?.text = question?.question
        iv_image?.setImageResource(question?.image!!)
        tv_option_one?.text = question?.optionOne
        tv_option_two?.text = question?.optionTwo
        tv_option_three?.text = question?.optionThree
        tv_option_four?.text = question?.optionFour

    }

    fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one!!)
        options.add(1, tv_option_two!!)
        options.add(2, tv_option_three!!)
        options.add(3,tv_option_four!!)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one!!, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two!!, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three!!, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four!!, 4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.USER_NAME, mUserName)
                            intent.putExtra(Constant.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constant.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctOption != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctOption, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList?.size) {
                        btn_submit?.text = "FINISH"
                    } else {
                        btn_submit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawAbleView: Int){
        when(answer){
            1 -> {
                tv_option_one!!.background = ContextCompat.getDrawable(this, drawAbleView)
            }
            2 -> {
                tv_option_two!!.background = ContextCompat.getDrawable(this, drawAbleView)
            }
            3 -> {
                tv_option_three!!.background = ContextCompat.getDrawable(this, drawAbleView)
            }
            4 -> {
                tv_option_four!!.background = ContextCompat.getDrawable(this, drawAbleView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg)
    }
}