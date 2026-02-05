package com.Coronado.Luis.miniweather

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvGreeting: TextView
    private lateinit var tvCity: TextView
    private lateinit var ivWeather: ImageView
    private lateinit var tvTemperature: TextView
    private lateinit var tvWeather: TextView
    private lateinit var spWeather: Spinner
    private lateinit var btnOpenSecond: Button

    private val weatherOptions = listOf(
        "Soleado", "Nublado", "Lluvioso", "Nieve", "Tormentas", "Ventoso"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de UI en onCreate
        tvGreeting = findViewById(R.id.tvGreeting)
        tvCity = findViewById(R.id.tvCity)
        ivWeather = findViewById(R.id.ivWeather)
        tvTemperature = findViewById(R.id.tvTemperature)
        tvWeather = findViewById(R.id.tvWeather)
        spWeather = findViewById(R.id.spWeather)
        btnOpenSecond = findViewById(R.id.btnOpenSecond)

        // Mandar texto e icono desde onCreate
        tvGreeting.text = "Hola,"
        tvCity.text = "Hermosillo"
        tvTemperature.text = "30°C"
        setWeatherUI("Soleado")

        // Spinner para cambiar clima
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, weatherOptions)
        spWeather.adapter = adapter

        spWeather.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selected = weatherOptions[position]
                setWeatherUI(selected)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Intent a segunda Activity
        btnOpenSecond.setOnClickListener {
            // Evento: click en btnOpenSecond
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("city", tvCity.text.toString())
            startActivity(intent)
        }
    }

    private fun setWeatherUI(weather: String) {
        tvWeather.text = weather

        val iconRes = when (weather) {
            "Soleado" -> R.drawable.ic_sunny
            "Nublado" -> R.drawable.ic_cloudy
            "Lluvioso" -> R.drawable.ic_rainy
            "Nieve" -> R.drawable.ic_snow
            "Tormentas" -> R.drawable.ic_storm
            "Ventoso" -> R.drawable.ic_windy
            else -> R.drawable.ic_sunny
        }
        ivWeather.setImageResource(iconRes)
    }
}