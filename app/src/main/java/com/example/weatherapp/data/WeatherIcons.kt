package com.example.weatherapp.data

import com.example.weatherapp.R

enum class WeatherIcons(private val iconName: String, private val iconCode: Set<Int>, val iconImg: Int) {
    CLOUDY_SUN("Sun & Clouds", setOf(2), R.drawable.cloudy_sun),
    CLOUD("Clouds", setOf(3), R.drawable.cloud),
    LIGHTING("Lightning", setOf(95, 96, 97, 98, 99), R.drawable.lighting),
    MOON("Night", setOf(), R.drawable.moon),
    RAIN("Rain", setOf(51, 53, 55, 61 ,63, 65, 80, 81, 82), R.drawable.rain),
    SNOW("Snow", setOf(70, 71, 72, 73, 74, 75, 85, 86), R.drawable.snowfall),
    SUN("Sun", setOf(0, 1), R.drawable.sunny),
    UNKNOWN("Unknown", setOf(-1), R.drawable.unknown);

    override fun toString() = iconName

    companion object {
        fun getWeatherType(mtoCode: Int) = entries.firstOrNull { it.iconCode.contains(mtoCode) } ?: UNKNOWN
    }
}