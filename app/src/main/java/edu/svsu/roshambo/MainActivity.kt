package edu.svsu.roshambo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var value = 0
    private var num = 0
    override fun onClick(v: View) {
        // Get a random number
        val rand = (1..3).random()

        // Assign opponent pick to rand number
        if (rand == 1) {
            txtOpp.text = "Rock"
        } else if (rand == 2) {
            txtOpp.text = "Paper"
        } else if (rand == 3) {
            txtOpp.text = "Scissors"
        }

        // Set button click actions
        when (v.id) {
             R.id.btnRock -> {
                 // 1 equals rock
                 num = 1
             }
             R.id.btnPaper -> {
                 // 2 equals paper
                 num = 2
             }
             R.id.btnScissors -> {
                 // 3 equals scissors
                 num = 3
             }
             R.id.btnReset -> {
                 num = 0
             }
        }

        // Decide the winner and keep score
        if (num == rand) {
            txtResult.text = "Tie!"
        } else if (num == 1 && rand == 3) {
            txtResult.text = "You Win!"
            value++
        } else if (num == 2 && rand == 1) {
            txtResult.text = "You Win!"
            value++
        } else if (num == 3 && rand == 2) {
            txtResult.text = "You Win!"
            value++
        } else if (num == 0) {
            value = 0
            txtResult.text = " "
            txtOpp.text = "-"
        } else {
            txtResult.text = "You Lose!"
            if (value != 0 && value >= 0) {
                value--
            }
        }
        txtValue.text = "$value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRock.setOnClickListener(this)
        btnPaper.setOnClickListener(this)
        btnScissors.setOnClickListener(this)
        btnReset.setOnClickListener(this)
        txtValue.setOnClickListener(this)
        txtResult.setOnClickListener(this)
        txtOpp.setOnClickListener(this)
    }
}
