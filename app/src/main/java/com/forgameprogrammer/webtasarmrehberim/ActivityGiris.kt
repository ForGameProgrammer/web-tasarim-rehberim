package com.forgameprogrammer.webtasarmrehberim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActivityGiris : AppCompatActivity() {

    lateinit var btnCikis: Button
    lateinit var btnInfo: Button
    lateinit var btnKonular: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris)
        btnKonular = findViewById(R.id.btnKonular)
        btnInfo = findViewById(R.id.btnInfo)
        btnCikis = findViewById(R.id.btnCikis)

        btnCikis.setOnClickListener {
            finish()
        }

        btnInfo.setOnClickListener {
            Toast.makeText(applicationContext, getText(R.string.hakkinda), Toast.LENGTH_LONG).show()
        }

        btnKonular.setOnClickListener {
            var intent = ActivityKonular.newIntent(applicationContext)
            startActivity(intent)
        }

    }
}
