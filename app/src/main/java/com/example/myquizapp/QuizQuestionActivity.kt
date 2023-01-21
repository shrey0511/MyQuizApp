package com.example.myquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionActivity : AppCompatActivity(), OnClickListener {

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

        progressBar= findViewById(R.id.progressBar)
        tvProgress= findViewById(R.id.tvProgress)
        tvQuestion= findViewById(R.id.tvQuestion)
        ivProgress= findViewById(R.id.iv_image)

        optionOne= findViewById(R.id.tvOptionOne)
        optionTwo= findViewById(R.id.tvOptionTwo)
        optionThree= findViewById(R.id.tvOptionThree)
        optionFour= findViewById(R.id.tvOptionFour)

        val questionsList = Constants.getQuestions()
        Log.i( "QuestionsList size is  ","${questionsList.size}")

        var currentPosition = 1
        val question : Question = questionsList[currentPosition - 1]
        ivProgress?.setImageResource(question.image)
        progressBar?.progress =currentPosition
        tvQuestion?.text = question.question
        tvProgress?.text = "$currentPosition/${progressBar?.max}"
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
    }
}