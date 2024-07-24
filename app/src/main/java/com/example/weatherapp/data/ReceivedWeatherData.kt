package com.example.weatherapp.data

import kotlinx.serialization.Serializable

@Serializable
data class ReceivedWeatherData(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val current_units: CurrentUnits,
    val current: Current,
    val hourly_units: HourlyUnits,
    val hourly: Hourly,
    val daily_units: DailyUnits,
    val daily: Daily
)

//relative to Current
@Serializable
data class CurrentUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val relative_humidity_2m: String,
    val apparent_temperature: String,
    val precipitation: String,
    val weather_code: String,
    val wind_speed_10m: String,
    val wind_direction_10m: String
)

@Serializable
data class Current(
    val time: String,
    val interval: Int,
    val temperature_2m: Double,
    val relative_humidity_2m: Int,
    val apparent_temperature: Double,
    val precipitation: Double,
    val weather_code: Int,
    val wind_speed_10m: Double,
    val wind_direction_10m: Int
)

//relative to Hour
@Serializable
data class HourlyUnits(
    val time: String,
    val temperature_2m: String,
    val apparent_temperature: String,
    val precipitation_probability: String,
    val weather_code: String,
    val wind_speed_10m: String,
    val wind_direction_10m: String,
    val uv_index: String
)

@Serializable
data class Hourly(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val apparent_temperature: List<Double>,
    val precipitation_probability: List<Int>,
    val weather_code: List<Int>,
    val wind_speed_10m: List<Double>,
    val wind_direction_10m: List<Int>,
    val uv_index: List<Double>
)

//relative to Day
@Serializable
data class DailyUnits(
    val time: String,
    val weather_code: String,
    val temperature_2m_max: String,
    val temperature_2m_min: String,
    val sunrise: String,
    val sunset: String,
    val uv_index_max: String,
    val precipitation_hours: String,
    val precipitation_probability_max: String,
    val wind_speed_10m_max: String,
    val wind_direction_10m_dominant: String
)

@Serializable
data class Daily(
    val time: List<String>,
    val weather_code: List<Int>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val sunrise: List<String>,
    val sunset: List<String>,
    val uv_index_max: List<Double>,
    val precipitation_hours: List<Double>,
    val precipitation_probability_max: List<Int>,
    val wind_speed_10m_max: List<Double>,
    val wind_direction_10m_dominant: List<Int>
)
