package com.example.weatherapp.data

import com.example.weatherapp.Utils

data class City(
    val name: String,
    val location: Point,
    var weatherData: WeatherData = Utils.connector.getWeatherData(location)!!
)
