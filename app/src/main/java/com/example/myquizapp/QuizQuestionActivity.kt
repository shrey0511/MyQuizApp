package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), OnClickListener {

    private var mCurrrentPosition : Int = 1
    private var mQuestionsList :ArrayList<Question>? = null
    private var mSelectedOptionNumber : Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswer : Int = 0

    private var btnSubmit : Button?= null
    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivProgress : ImageView? = null

    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName=intent.getStringExtra(Constants.UserName)

        progressBar= findViewById(R.id.progressBar)
        tvProgress= findViewById(R.id.tvProgress)
        tvQuestion= findViewById(R.id.tvQuestion)
        ivProgress= findViewById(R.id.iv_image)

        optionOne= findViewById(R.id.tvOptionOne)
        optionTwo= findViewById(R.id.tvOptionTwo)
        optionThree= findViewById(R.id.tvOptionThree)
        optionFour= findViewById(R.id.tvOptionFour)
        btnSubmit= findViewById(R.id.submit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {

        defaultOptionsView()
        var currentPosition = 1
        val question: Question = mQuestionsList!![mCurrrentPosition - 1]
        ivProgress?.setImageResource(question.image)
        progressBar?.progress = mCurrrentPosition
        tvQuestion?.text = question.question
        tvProgress?.text = "$mCurrrentPosition/${progressBar?.max}"
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrrentPosition == mQuestionsList!!.size){
            btnSubmit?.text="Finish"
        }else{
            btnSubmit?.text="Submit"
        }
    }

    fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#FF0000"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.background_border
            )
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int){
        defaultOptionsView()

        mSelectedOptionNumber=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOptionOne->{
                optionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tvOptionTwo->{
                optionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tvOptionThree->{
                optionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tvOptionFour->{
                optionFour?.let{
                    selectedOptionView(it,4)
                }
            }

            R.id.submit->{
                if(mSelectedOptionNumber==0){
                    mCurrrentPosition++

                    when{
                        mCurrrentPosition<=mQuestionsList!!.size ->{
                            setQuestion()
                        }else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.UserName,mUserName)
                            intent.putExtra(Constants.CorrectAnswers,mCorrectAnswer)
                            intent.putExtra(Constants.TotalQuestions,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrrentPosition-1)
                    if(question!!.correctAns!=mSelectedOptionNumber){
                        answerView(mSelectedOptionNumber,R.drawable.wrong_answer_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAns,R.drawable.correct_answer_bg)

                    if(mCurrrentPosition==mQuestionsList!!.size){
                        btnSubmit?.text="Finish"
                    }else{
                        btnSubmit?.text="Go to Next Question"
                    }
                    mSelectedOptionNumber=0
                }

            }
        }
    }
    private fun answerView(answer : Int ,drawableView : Int){
        when(answer){
            1-> {
                optionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2-> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3-> {
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4-> {
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}