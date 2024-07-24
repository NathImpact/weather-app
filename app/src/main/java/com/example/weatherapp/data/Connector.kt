package com.example.weatherapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class Connector {
    fun getWeatherData(location: Point): WeatherData? {
        val url = "https://api.open-meteo.com/v1/forecast?latitude=${location.lat}&longitude=${location.lon}&current=temperature_2m,relative_humidity_2m,apparent_temperature,precipitation,weather_code,wind_speed_10m,wind_direction_10m&hourly=temperature_2m,apparent_temperature,precipitation_probability,weather_code,wind_speed_10m,wind_direction_10m,uv_index&daily=weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,precipitation_hours,precipitation_probability_max,wind_speed_10m_max,wind_direction_10m_dominant&timezone=Europe%2FBerlin"
        return runCatching {
            runBlocking {
                withContext(Dispatchers.IO) {
                    transformWeatherData(Json.decodeFromString<ReceivedWeatherData>(sendGetRequest(url)))
                }
            }
        }.getOrNull()
    }

    fun getGeocodingData(city: String, numberOfResults: Int = 10): List<City>? {
        val url = "https://api-adresse.data.gouv.fr/search/?q=$city&type=municipality&limit=$numberOfResults"
        return runCatching {
            getCitiesFromFeatures(Json.decodeFromString<FeatureCollection>(sendGetRequest(url)))
        }.getOrNull()
    }

    private fun sendGetRequest(url: String): String {
        val urlObj = URL(url)
        val connection = urlObj.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        val responseCode = connection.responseCode
        println("Response Code: $responseCode")

        return if (responseCode == HttpURLConnection.HTTP_OK) {
            connection.inputStream.bufferedReader().use { it.readText() }
        } else {
            "Error: $responseCode"
        }
    }
}