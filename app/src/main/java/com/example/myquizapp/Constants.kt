package com.example.myquizapp

object Constants {

    const val UserName:String="user_name"
    const val TotalQuestions:String="total_questions"
    const val CorrectAnswers:String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val ques1 = Question(
            1,"What is the name of this Character ?",
            R.drawable.images,
            "Neji Hyuga","Itachi Uchia","Naruto Uzumaki","Kurama",
            3
        )
        questionList.add(ques1)

        val ques2 = Question(
            2,"What is the name of this character ?",
            R.drawable._8d134c0cb44d6959e6b94e5a2c7f250,
            "Zeke","Eren","Erwin","Levi",
            4
        )
        questionList.add(ques2)

        val ques3 = Question(
            3,"What is the name of this character ?",
            R.drawable._fubt6xqxnhhnfomchit7i34na,
            "Krillin","Bardock","Goku","Black",
            3
        )
        questionList.add(ques3)

        val ques4 = Question(
            4,"What is the name of this character ?",
            R.drawable._itbtghe9qm81,
            "L","Ryuk","Light","Watari",
            3
        )
        questionList.add(ques4)

        val ques5 = Question(
            5,"What is the name of this character ?",
            R.drawable.b85_mkvbh2yjxjmx_bk3b,
            "Jiraya","Kakashi","Guy","Itachi",
            2
        )
        questionList.add(ques5)

        val ques6 = Question(
            6,"What is the name of this character ?",
            R.drawable.gojo_satoru_1_1024x576,
            "Gojo","Itadori","Panda","Sakuna",
            1
        )
        questionList.add(ques6)

        val ques7 = Question(
            7,"What is the name of this character ?",
            R.drawable.tumblr_5e417ff7cf74646a535e5ea21566f6c7_16298aba_1280,
            "Isagi","Bachira","Nagi","Barao",
            4
        )
        questionList.add(ques7)

        val ques8 = Question(
            8,"What is the name of this character ?",
            R.drawable.kuroo_ova,
            "Tetsuro","Oichawa","Hinata","Nishinoya",
            1
        )
        questionList.add(ques8)
        return questionList
    }

}