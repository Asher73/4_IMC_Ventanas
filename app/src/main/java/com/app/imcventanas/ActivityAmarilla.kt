package com.app.imcventanas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_amarilla.*
import kotlinx.android.synthetic.main.activity_verde.*

class ActivityAmarilla : AppCompatActivity() {

    companion object {
        val EXTRA_IMC = "EXTRA_IMC"
        private val DEFAULT_IMC: Double = -1.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amarilla)

        val intent = intent
        if(intent != null && intent.hasExtra(EXTRA_IMC)){
            val imc : Double = intent.getDoubleExtra(EXTRA_IMC, DEFAULT_IMC)
            val let: String
            tvAmarillo.setText("Tu IMC = ${imc}")
            tvtitleamarillo.setText("Sobrepeso")
        }
    }
}
