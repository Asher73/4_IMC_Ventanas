package com.app.imcventanas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_amarilla.*
import kotlinx.android.synthetic.main.activity_roja.*

class ActivityRoja : AppCompatActivity() {

    companion object {
        val EXTRA_IMC = "EXTRA_IMC"
        private val DEFAULT_IMC: Double = -1.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roja)

        val intent = intent
        if(intent != null && intent.hasExtra(EXTRA_IMC)){
            val imc : Double = intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC)
            tvRojo.setText("Tu IMC = ${imc}")
            tvtitlerojo.setText("Obesidad")
        }
    }
}
