package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import android.widget.Button
import android.widget.ImageButton
import java.util.*
import android.os.CountDownTimer as CountDownTimer1

class GameTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_time)
        window.setFlags(
            FLAG_FULLSCREEN,
        FLAG_FULLSCREEN
        )

        val basicTime = intent.getStringExtra("basicTime")
        val incTime = intent.getStringExtra("incrementTime")

        val btnColor = intent.getStringExtra("btnColor")



        val kameraBtn = findViewById<Button>(R.id.buttonPlayer2)
        val punacBtn = findViewById<Button>(R.id.buttonPlayer1)
        var timerPlayerCharger: android.os.CountDownTimer
        var timerPlayerCamera: android.os.CountDownTimer

        val pauseBtn = findViewById<ImageButton>(R.id.pauseButton)
        val playBtn = findViewById<ImageButton>(R.id.playButton)




        var basicTimeLongPC = basicTime?.toLong()
        val incTimeLong = incTime?.toLong()

        kameraBtn.text = basicTime+ ":0"
        punacBtn.text = basicTime + ":0"



        punacBtn.setBackgroundColor(Color.parseColor(btnColor))
        kameraBtn.setBackgroundColor(Color.parseColor(btnColor))



        var basicTimeLongPcam = basicTimeLongPC

        if (basicTimeLongPC != null) {
            basicTimeLongPC = basicTimeLongPC*60*1000
            basicTimeLongPcam = basicTimeLongPC
        }

        timerPlayerCharger = object : android.os.CountDownTimer(basicTimeLongPC!!,1000){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                val minsLeft = (timeLeft/60).toInt()
                val secLeft = timeLeft%60
                punacBtn.text = "$minsLeft:$secLeft"
                basicTimeLongPC = timeLeft
            }

            override fun onFinish() {

            }
        }

        timerPlayerCamera = object : android.os.CountDownTimer(basicTimeLongPcam!!, 1000){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000

                val minsLeft = (timeLeft/60).toInt()
                val secLeft = timeLeft%60

                kameraBtn.text = "$minsLeft:$secLeft"
                basicTimeLongPcam = timeLeft
            }

            override fun onFinish() {

            }
        }

        kameraBtn.setOnClickListener {
            playBtn.visibility = View.INVISIBLE
            pauseBtn.visibility = View.VISIBLE

            kameraBtn.isClickable = false
            punacBtn.isClickable = true


            timerPlayerCamera.cancel()

            timerPlayerCharger = object : android.os.CountDownTimer(basicTimeLongPC!!, 1000){
                override fun onTick(millisUntilFinished: Long) {

                    var timeLeft = millisUntilFinished / 1000

                    var minsLeft = (timeLeft/60).toInt()


                    var secLeft = timeLeft%60

                    punacBtn.text = "$minsLeft:$secLeft"

                    basicTimeLongPC = timeLeft*1000 + incTimeLong!! * 1000


                    if(minsLeft < 1 && secLeft <= 15){
                        punacBtn.setBackgroundColor(Color.parseColor("#FFC30303"))
                    }
                }

                override fun onFinish() {
                    punacBtn.isClickable=false
                    punacBtn.setBackgroundColor(Color.parseColor("#000000"))
                }
            }

            kameraBtn.text = (basicTimeLongPcam!!/1000).toString()
            val minsLeft = ((basicTimeLongPcam!!/1000)/60).toInt()
            val secLeft = (basicTimeLongPcam!!/1000).toInt()%60
            kameraBtn.text = "$minsLeft:$secLeft"

            if (minsLeft > 1 || secLeft > 15){
                kameraBtn.setBackgroundColor(Color.parseColor(btnColor))
            }

            timerPlayerCharger.start()

        }

        punacBtn.setOnClickListener{

            playBtn.visibility = View.INVISIBLE
            pauseBtn.visibility = View.VISIBLE

            timerPlayerCharger.cancel()

            punacBtn.isClickable = false
            kameraBtn.isClickable = true


            timerPlayerCamera = object : android.os.CountDownTimer(basicTimeLongPcam!!, 1000){
                override fun onTick(millisUntilFinished: Long) {

                    var timeLeft = millisUntilFinished / 1000

                    var minsLeft = (timeLeft/60).toInt()
                    var secLeft = timeLeft%60


                    kameraBtn.text = "$minsLeft:$secLeft"

                    basicTimeLongPcam = timeLeft * 1000 + incTimeLong!!*1000


                    if(minsLeft < 1 && secLeft <= 15){
                        kameraBtn.setBackgroundColor(Color.parseColor("#FFC30303"))
                    }

                }

                override fun onFinish() {
                    kameraBtn.isClickable = false
                    kameraBtn.setBackgroundColor(Color.parseColor("#000000"))
                }
            }

            val minsLeft = ((basicTimeLongPC!!/60)/1000).toInt()
            val secLeft = (basicTimeLongPC!!/1000).toInt()%60

            punacBtn.text = "$minsLeft:$secLeft"

            if (minsLeft > 1 || secLeft > 15){
                punacBtn.setBackgroundColor(Color.parseColor(btnColor))
            }

            timerPlayerCamera.start()
        }

        playBtn.setOnClickListener{

            playBtn.visibility = View.INVISIBLE
            pauseBtn.visibility = View.VISIBLE


            if (kameraBtn.isClickable){
                timerPlayerCamera.start()

            } else {
                timerPlayerCharger.start()
            }

        }

        pauseBtn.setOnClickListener{
            playBtn.visibility = View.VISIBLE
            pauseBtn.visibility = View.INVISIBLE


            timerPlayerCamera.cancel()
            timerPlayerCharger.cancel()
        }



    }
}

