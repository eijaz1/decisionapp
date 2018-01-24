package com.example.android.decisionmaker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity() {

    var listOfChoices: ArrayList<String> = ArrayList()
    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bu_make_decision.setOnClickListener {
            addChoices()

            if (listOfChoices.size < 2) {
                Toast.makeText(this, "Must have at least two choices", Toast.LENGTH_SHORT).show()
                listOfChoices.clear()
            } else {
                makeDecision()
            }
        }
    }

    fun addChoices() {
        if (et_choice1.text == null || et_choice1.text.isBlank()) {

        } else {
            listOfChoices.add(et_choice1.text.toString())
        }

        if (et_choice2.text == null || et_choice2.text.isBlank()) {

        } else {
            listOfChoices.add(et_choice2.text.toString())
        }

        if (et_choice3.text == null || et_choice3.text.isBlank()) {

        } else {
            listOfChoices.add(et_choice3.text.toString())
        }

        if (et_choice4.text == null || et_choice4.text.isBlank()) {

        } else {
            listOfChoices.add(et_choice4.text.toString())
        }
    }

    fun makeDecision() {



        var randomChoice: Int = (Math.random() * (listOfChoices.size)).toInt()
        var result: String = listOfChoices.get(randomChoice)

        val intent = Intent(this, ResultsActivity::class.java)
        intent.putExtra("result", result)

        println(listOfChoices)

        startActivity(intent)

        listOfChoices.clear()



        }

    }


