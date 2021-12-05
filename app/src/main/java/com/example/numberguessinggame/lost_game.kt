package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class lost_game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_game)

        val correctNumber=intent.getIntExtra("numberIs",0)
        findViewById<TextView>(R.id.displayNumber).text="$correctNumber"
    }
}