package com.Coronado.Luis.miniweather

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvInfo: TextView = findViewById(R.id.tvInfo)
        val city = intent.getStringExtra("city") ?: "Ciudad desconocida"
        tvInfo.text = "Segunda pantalla\nCiudad recibida: $city"
    }
}