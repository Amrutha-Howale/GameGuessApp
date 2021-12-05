package com.example.numberguessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.util.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var initialnum:Int =700 ;
        //var initalnum:Int = nextInt(1,1000)
        var count=0

        val Number = findViewById<TextInputLayout>(R.id.guessNumber)
        val button = findViewById<Button>(R.id.button3)
        val resultdisplay = findViewById<TextView>(R.id.result)

        /*button.setOnClickListener {
            val numberenter = Number.editText?.text.toString().toInt()

            if(numberenter==0)
            {
                resultdisplay.text = "Enter valid number"
            }
            else if(numberenter>initalnum){
                resultdisplay.text = "no :( my number is smaller"
            }
            else if(numberenter<initalnum){
                resultdisplay.text = "no :( my number is bigger"
            }
            else
            {
                resultdisplay.text = "You are right :)"
            }*/

        button.setOnClickListener {
            try {
                val userName=Number.editText?.text?.toString()
                val userGuess = Integer.parseInt(userName);

                val answer=
                    if(userGuess < 0 ) { count++
                        "Please Enter a Positive Digit"}
                    else if(userGuess > initialnum){ count ++
                        "No;)  My Number is Smaller"}
                    else if(userGuess< initialnum){ count++
                        "No;) My Number is Greater "}
                    else{
                        val wonScreenIntent= Intent(this,won_game::class.java)
                        wonScreenIntent.putExtra("numberIs",initialnum)
                        startActivity(wonScreenIntent)
                        "!!congo!!"
                    }
                resultdisplay.text = "$answer"
                if (count==12)
                {
                    val lastScreenIntent= Intent(this,lost_game::class.java)
                    lastScreenIntent.putExtra("numberIs",initialnum)
                    startActivity(lastScreenIntent)
                }
            }  catch (e:Exception){
                resultdisplay.text= "Please Enter a number"
            }


        }
    }
}