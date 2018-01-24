package com.example.android.decisionmaker

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        var intent: Intent = getIntent()
        var finalResult: String = intent.getStringExtra("result")

//        tv_result.text = finalResult

        val handler = Handler()

        handler.postDelayed(object:Runnable {
            public override fun run() {
                tv_result.text = finalResult
                av_result.setAnimation("drink.json")
                av_result.loop(false)
                av_result.playAnimation()
                bu_edit_choices.visibility = View.VISIBLE
            }
        }, 2000)

        bu_edit_choices.setOnClickListener {
            finish()
        }

    }

}
