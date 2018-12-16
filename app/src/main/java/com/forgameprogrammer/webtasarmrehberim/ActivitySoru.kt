package com.forgameprogrammer.webtasarmrehberim

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.beust.klaxon.Klaxon
import com.forgameprogrammer.webtasarmrehberim.Classes.Soru1
import com.forgameprogrammer.webtasarmrehberim.Classes.Soru2

class ActivitySoru : AppCompatActivity() {

    lateinit var fabGoster:FloatingActionButton
    lateinit var editCevap: EditText
    lateinit var tvSoru1: TextView
    lateinit var tvSoru2: TextView
    lateinit var tvCevap: TextView
    lateinit var tvSoru: TextView
    var konu: Soru1? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soru)

        fabGoster = findViewById(R.id.fabGoster)
        editCevap = findViewById(R.id.editCevap)
        tvSoru = findViewById(R.id.tvSoru)
        tvSoru1= findViewById(R.id.tvSoru1)
        tvSoru2= findViewById(R.id.tvSoru2)
        tvCevap=findViewById(R.id.tvCevap)
        tvCevap.visibility = View.GONE

        val bundle=intent.extras

        if(bundle==null) finish()
        val soru:String?
        soru = bundle?.getString(ActivitySoru2.SORU)
        if(soru== null) finish()
        var jsonSorular = ""
        //TODO: RAW Değişecek
        resources.openRawResource(R.raw.a).bufferedReader().use {
            jsonSorular= it.readText()
        }
        if (jsonSorular=="") {
            Log.e("ActivitySoru1", "json Dosyası Boş yada okunamadı!")
            finish()
        }
        val sorular = Klaxon().parseArray<Soru2>(jsonSorular)

        sorular!!.forEach {
            if(soru!!.toLowerCase() == it.isim.toLowerCase().trim())  konu=it
        }
        if (konu == null) {
            Log.e("ActivitySoru1", "Aranan Soru bulunamadı!")
            finish()
        }

        tvSoru.setText(konu!!.soru)
        tvCevap.setText(konu!!.cevapYazi)
        tvSoru1.setText(konu!!.ustSoru)
        tvSoru2.setText(konu!!.altSoru)
        fabGoster.setOnClickListener {
            tvCevap.visibility = View.VISIBLE
            tvCevap.setTextColor(Color.RED)
            if (editCevap.text.toString().toLowerCase().trim() == konu!!.cevap.toLowerCase().trim())
            {
                tvCevap.setTextColor(Color.GREEN)
            }
        }

    }

    companion object {
        const val SORU = "SORU"
        fun newIntent(context: Context, soru:String): Intent {
            val intent = Intent(context, ActivitySoru::class.java)
            intent.putExtra(SORU, soru)
            return intent
        }
    }
}
