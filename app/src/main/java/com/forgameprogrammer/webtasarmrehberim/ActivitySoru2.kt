package com.forgameprogrammer.webtasarmrehberim

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.beust.klaxon.Klaxon
import com.forgameprogrammer.webtasarmrehberim.Classes.Soru2
import java.util.*

class ActivitySoru2 : AppCompatActivity() {

    lateinit var tvSoru:TextView
    lateinit var tvCevap:TextView
    lateinit var btnCevap1:Button
    lateinit var btnCevap2:Button
    lateinit var btnCevap3:Button
    lateinit var btnCevap4:Button
    var konu:Soru2? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soru2)
        tvSoru = findViewById(R.id.tvSoru3)
        tvCevap = findViewById(R.id.tvCevap2)
        btnCevap1 = findViewById(R.id.btnCevap1)
        btnCevap2 = findViewById(R.id.btnCevap2)
        btnCevap3 = findViewById(R.id.btnCevap3)
        btnCevap4 = findViewById(R.id.btnCevap4)
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
            Log.e("ActivitySoru2", "json Dosyası Boş yada okunamadı!")
            finish()
        }
        val sorular = Klaxon().parseArray<Soru2>(jsonSorular)

        sorular!!.forEach {
            if(soru!!.toLowerCase() == it.isim.toLowerCase().trim())  konu=it
        }
        if (konu == null) {
            Log.e("ActivitySoru2", "Aranan Soru bulunamadı!")
            finish()
        }

        val rasgele = (1..4).random()
        val buttonlar = mutableListOf(btnCevap1, btnCevap2, btnCevap3, btnCevap4)
        val btn = buttonlar[rasgele]
        buttonlar.removeAt(rasgele)
        buttonlar.add(0, btn)
        buttonlar[0].text = konu!!.dogruCevap
        buttonlar[1].text = konu!!.cevap2
        buttonlar[2].text = konu!!.cevap3
        buttonlar[3].text = konu!!.cevap4
        buttonlar.forEach {
            it.setOnClickListener {
                tvCevap.visibility = View.VISIBLE
                tvCevap.setTextColor(Color.RED)
            }
        }
        buttonlar[0].setOnClickListener {
            tvCevap.visibility = View.VISIBLE
            tvCevap.setTextColor(Color.GREEN)
        }

        tvSoru.setText(konu!!.soru)
        tvCevap.setText(konu!!.cevapYazi)

    }

    companion object {
        const val SORU = "SORU"
        fun newIntent(context: Context, soru:String): Intent {
            val intent = Intent(context, ActivitySoru2::class.java)
            intent.putExtra(SORU, soru)
            return intent
        }
    }

    fun IntRange.random() =
        Random().nextInt((endInclusive + 1) - start) +  start
}
