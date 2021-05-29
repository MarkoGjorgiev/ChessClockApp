package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn);

        val baseTimeText = findViewById<TextView>(R.id.txtBasicTime);
        val incTimeText = findViewById<TextView>(R.id.txtIncTime);
        val baseTimeSeek = findViewById<SeekBar>(R.id.seekBarBase);
        val incTimeSeek = findViewById<SeekBar>(R.id.seekBarIncrement);

        val bulet10Btn = findViewById<Button>(R.id.bulet10)
        val bullet11Btn = findViewById<Button>(R.id.bullet11)
        val bullet20Btn = findViewById<Button>(R.id.bullet20)

        val blitz30 = findViewById<Button>(R.id.blitz30)
        val blitz31 = findViewById<Button>(R.id.blitz31)
        val blitz50 = findViewById<Button>(R.id.blitz50)

        val rapid100 = findViewById<Button>(R.id.rapid100)
        val rapid1010 = findViewById<Button>(R.id.rapid1010)
        val rapid150 = findViewById<Button>(R.id.rapid150)

        val rapidBtnColor = "#1B8F17"
        val blitzBtnColor = "#D2FFC107"
        val bulletBtnColor = "#E1C850"





        rapid150.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)
            intent.putExtra("basicTime","15")
            intent.putExtra("incrementTime", "0")
            intent.putExtra("btnColor", rapidBtnColor)
            startActivity(intent)
        }

        rapid1010.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)
            intent.putExtra("basicTime","10")
            intent.putExtra("incrementTime", "10")
            intent.putExtra("btnColor", rapidBtnColor)
            startActivity(intent)
        }


        rapid100.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)
            intent.putExtra("basicTime","10")
            intent.putExtra("incrementTime", "0")
            intent.putExtra("btnColor", rapidBtnColor)
            startActivity(intent)
        }

        blitz50.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)
            intent.putExtra("basicTime","5")
            intent.putExtra("incrementTime", "0")
            intent.putExtra("btnColor", blitzBtnColor)
            startActivity(intent)
        }

        blitz31.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)
            intent.putExtra("basicTime","3")
            intent.putExtra("incrementTime", "1")
            intent.putExtra("btnColor", blitzBtnColor)
            startActivity(intent)
        }

        blitz30.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)
            intent.putExtra("basicTime","3")
            intent.putExtra("incrementTime", "0")
            intent.putExtra("btnColor", blitzBtnColor)
            startActivity(intent)
        }

        bullet20Btn.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)
            intent.putExtra("basicTime","2")
            intent.putExtra("incrementTime", "0")
            intent.putExtra("btnColor", bulletBtnColor)
            startActivity(intent)
        }

        bullet11Btn.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)

            intent.putExtra("basicTime","1")
            intent.putExtra("incrementTime", "1")
            intent.putExtra("btnColor", bulletBtnColor)
            startActivity(intent)
        }

        bulet10Btn.setOnClickListener{
            val intent = Intent(this, GameTime::class.java)

            intent.putExtra("basicTime","1")
            intent.putExtra("incrementTime", "0")
            intent.putExtra("btnColor", bulletBtnColor)
            startActivity(intent)

        }




        baseTimeSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                baseTimeText.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        incTimeSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                incTimeText.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        startBtn.setOnClickListener{
            val intent = Intent(this,GameTime::class.java)

            intent.putExtra("basicTime",baseTimeText.text.toString())
            intent.putExtra("incrementTime", incTimeText.text.toString())
            intent.putExtra("type", "custom")

            if (baseTimeSeek.progress < 3){
                intent.putExtra("btnColor", bulletBtnColor)
            } else if (baseTimeSeek.progress in 3..4){
                intent.putExtra("btnColor", blitzBtnColor)
            } else {
                intent.putExtra("btnColor", rapidBtnColor)
            }


            startActivity(intent)

        }




    }
}