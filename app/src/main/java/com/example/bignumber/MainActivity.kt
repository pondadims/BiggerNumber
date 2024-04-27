package com.example.bignumber

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import kotlin.random.Random
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {

    private var point = 0
    private var count = 0
    private var leftVal = 0
    private var rightVal = 0
    private lateinit var leftBtn: Button
    private lateinit var rightBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        leftBtn = findViewById(R.id.leftbtn)
        rightBtn = findViewById(R.id.rightbtn)

        startGame()

        leftBtn.setOnClickListener { onLeftButtonClick() }
        rightBtn.setOnClickListener { onRightButtonClick() }
    }

    private fun startGame() {
        if (count < 10) {
            leftVal = randomnumber()
            rightVal = randomnumber()
            leftBtn.text = leftVal.toString()
            rightBtn.text = rightVal.toString()
        } else {
            showScore()
        }
    }

    private fun randomnumber(): Int {
        return Random.nextInt(1, 100)
    }

    private fun onLeftButtonClick() {
        if (leftVal > rightVal) {
            point++
        }
        count++
        startGame()
    }

    private fun onRightButtonClick() {
        if (rightVal > leftVal) {
            point++
        }
        count++
        startGame()
    }

    private fun showScore() {
        val scoreMessage = "Game Over! Your score is $point"
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        scoreTextView.text = scoreMessage
        scoreTextView.visibility = View.VISIBLE
    }

}
