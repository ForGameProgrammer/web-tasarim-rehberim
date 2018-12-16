package com.forgameprogrammer.webtasarmrehberim

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityKonular : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konular)
    }


    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ActivityKonular::class.java)
            return intent
        }
    }
}
