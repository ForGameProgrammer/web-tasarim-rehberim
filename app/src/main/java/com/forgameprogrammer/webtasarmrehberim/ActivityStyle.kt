package com.forgameprogrammer.webtasarmrehberim

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityStyle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_style)
    }

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ActivityStyle::class.java)
            return intent
        }
    }
}
