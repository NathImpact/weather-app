package com.example.weatherapp.data

import com.example.weatherapp.R

enum class WeatherIcons(private val iconName: String, private val iconCode: Set<Int>, val iconImg: Int) {
    CLEAR_SKY("Clear Sky", setOf(0), R.drawable.clear_sky),
    MAINLY_CLEAR("Mainly Clear", setOf(1), R.drawable.mainly_clear),
    PARTLY_CLOUDY("Partly Cloudy", setOf(2), R.drawable.partly_cloudy),
    OVERCAST("Overcast", setOf(3), R.drawable.overcast),
    FOG("Fog", setOf(45, 48), R.drawable.fog),
    DRIZZLE_LIGHT("Drizzle, Light", setOf(51), R.drawable.drizzle_light),
    DRIZZLE_MEDIUM("Drizzle, Medium", setOf(53), R.drawable.drizzle_medium),
    DRIZZLE_HEAVY("Drizzle, Heavy", setOf(55), R.drawable.drizzle_heavy),
    FREEZING_DRIZZLE_LIGHT("Freezing Drizzle, Light", setOf(56), R.drawable.freezing_drizzle_light),
    FREEZING_DRIZZLE_HEAVY("Freezing Drizzle, Heavy", setOf(57), R.drawable.freezing_drizzle_heavy),
    RAIN_LIGHT("Rain, Light", setOf(61), R.drawable.rain_light),
    RAIN_MEDIUM("Rain, Medium", setOf(63), R.drawable.rain_medium),
    RAIN_HEAVY("Rain, Heavy", setOf(65), R.drawable.rain_heavy),
    FREEZING_RAIN_LIGHT("Freezing Rain, Light", setOf(66), R.drawable.freezing_rain_light),
    FREEZING_RAIN_HEAVY("Freezing Rain, Heavy", setOf(67), R.drawable.freezing_rain_heavy),
    SNOW_FALL_LIGHT("Snow Fall, Light", setOf(71), R.drawable.snowfall_light),
    SNOW_FALL_MEDIUM("Snow Fall, Medium", setOf(73), R.drawable.snowfall_medium),
    SNOW_FALL_HEAVY("Snow Fall, Heavy", setOf(75), R.drawable.snowfall_heavy),
    SNOW_GRAINS("Snow Grains", setOf(77), R.drawable.snow_grains),
    RAIN_SHOWERS_LIGHT("Rain Showers, Light", setOf(80), R.drawable.rain_shower_light),
    RAIN_SHOWERS_MEDIUM("Rain Showers, Medium", setOf(81), R.drawable.rain_shower_medium),
    RAIN_SHOWERS_HEAVY("Rain Showers, Heavy", setOf(82), R.drawable.rain_shower_heavy),
    SNOW_SHOWERS_LIGHT("Snow Showers, Light", setOf(85), R.drawable.snow_shower_light),
    SNOW_SHOWERS_HEAVY("Snow Showers, Heavy", setOf(86), R.drawable.snow_shower_heavy),
    THUNDERSTORM("Thunderstorm", setOf(95), R.drawable.thunderstorm),
    THUNDERSTORM_WITH_HAIL_LIGHT("Thunderstorm with Hail, Light", setOf(96), R.drawable.thunderstorm_with_hail_light),
    THUNDERSTORM_WITH_HAIL_HEAVY("Thunderstorm with Hail, Heavy", setOf(99), R.drawable.thunderstorm_with_hail_heavy),
    UNKNOWN("Unknown", setOf(-1), R.drawable.unknown_weather);

    override fun toString() = iconName

    companion object {
        fun getWeatherType(mtoCode: Int) = entries.firstOrNull { it.iconCode.contains(mtoCode) } ?: UNKNOWN
    }
}