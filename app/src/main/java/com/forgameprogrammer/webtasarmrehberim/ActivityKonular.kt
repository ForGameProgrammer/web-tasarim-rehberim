package com.forgameprogrammer.webtasarmrehberim

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityKonular : AppCompatActivity() {

    lateinit var btnHead:Button
    lateinit var btnBody:Button
    lateinit var btnStyle:Button
    lateinit var btnTitle:Button
    lateinit var btnH1:Button
    lateinit var btnA:Button
    lateinit var btnImg:Button
    lateinit var btnDiv:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konular)

        btnA = findViewById(R.id.btnA)
        btnBody = findViewById(R.id.btnBody)
        btnDiv = findViewById(R.id.btnDiv)
        btnH1 = findViewById(R.id.btnH1)
        btnHead = findViewById(R.id.btnHead)
        btnImg= findViewById(R.id.btnImg)
        btnStyle = findViewById(R.id.btnStyle)
        btnTitle = findViewById(R.id.btnTitle)

        btnA.setOnClickListener {
            startActivity(ActivitySoru.newIntent(applicationContext, "a"))
        }
        btnBody.setOnClickListener {
            startActivity(ActivitySoru.newIntent(applicationContext, "body"))
        }
        btnDiv.setOnClickListener {
            startActivity(ActivitySoru2.newIntent(applicationContext, "div"))
        }
        btnH1.setOnClickListener {
            startActivity(ActivitySoru.newIntent(applicationContext, "h1"))
        }
        btnHead.setOnClickListener {
            startActivity(ActivitySoru2.newIntent(applicationContext, "head"))
        }
        btnImg.setOnClickListener {
            startActivity(ActivitySoru.newIntent(applicationContext, "img"))
        }
        btnStyle.setOnClickListener {
            startActivity(ActivitySoru2.newIntent(applicationContext, "style"))
        }
        btnTitle.setOnClickListener {
            startActivity(ActivitySoru2.newIntent(applicationContext, "title"))
        }
    }


    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ActivityKonular::class.java)
            return intent
        }
    }
}
