package com.app.imcventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var peso: Int = 0
    var altura: Double = 0.0
    var imc: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun CalcularIMC(v: View){
        if(etPeso.text.isEmpty()){
            Toast.makeText(this, "Falta el Peso en Kg", Toast.LENGTH_LONG).show()
            etPeso.requestFocus()
        }
        else if (etAltura.text.isEmpty()) {
            Toast.makeText(this, "Falta Altura en Mts", Toast.LENGTH_LONG).show()
            etAltura.requestFocus()
        } else {
            peso = etPeso.text.toString().toInt()
            altura = etAltura.text.toString().toDouble()
            imc = peso / (altura * altura)
            when{
                imc < 25 -> {
                    val  intent = Intent(this, ActivityVerde::class.java)
                    intent.putExtra(ActivityVerde.EXTRA_IMC, imc)
                    startActivity(intent)
                }
                imc > 25 && imc < 30 -> {
                    val intent = Intent(this, ActivityAmarilla::class.java)
                    intent.putExtra(ActivityAmarilla.EXTRA_IMC, imc)
                    startActivity(intent)
                }
                imc > 30 -> {
                    val intent = Intent(this, ActivityRoja::class.java)
                    intent.putExtra(ActivityRoja.EXTRA_IMC, imc)
                    startActivity(intent)
                }
            }
        }
    }
}
