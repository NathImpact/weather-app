package com.example.weatherapp.data

import com.example.weatherapp.R

enum class WeatherIcons(val iconNameRes: Int, private val iconCode: Set<Int>, val iconImg: Int) {
    CLEAR_SKY(R.string.clear_sky, setOf(0), R.drawable.clear_sky),
    MAINLY_CLEAR(R.string.mainly_clear, setOf(1), R.drawable.mainly_clear),
    PARTLY_CLOUDY(R.string.partly_cloudy, setOf(2), R.drawable.partly_cloudy),
    OVERCAST(R.string.overcast, setOf(3), R.drawable.overcast),
    FOG(R.string.fog, setOf(45, 48), R.drawable.fog),
    DRIZZLE_LIGHT(R.string.drizzle_l, setOf(51), R.drawable.drizzle_light),
    DRIZZLE_MEDIUM(R.string.drizzle_m, setOf(53), R.drawable.drizzle_medium),
    DRIZZLE_HEAVY(R.string.drizzle_h, setOf(55), R.drawable.drizzle_heavy),
    FREEZING_DRIZZLE_LIGHT(R.string.freezing_drizzle_l, setOf(56), R.drawable.freezing_drizzle_light),
    FREEZING_DRIZZLE_HEAVY(R.string.freezing_drizzle_h, setOf(57), R.drawable.freezing_drizzle_heavy),
    RAIN_LIGHT(R.string.rain_l, setOf(61), R.drawable.rain_light),
    RAIN_MEDIUM(R.string.rain_m, setOf(63), R.drawable.rain_medium),
    RAIN_HEAVY(R.string.rain_h, setOf(65), R.drawable.rain_heavy),
    FREEZING_RAIN_LIGHT(R.string.freezing_rain_l, setOf(66), R.drawable.freezing_rain_light),
    FREEZING_RAIN_HEAVY(R.string.freezing_rain_h, setOf(67), R.drawable.freezing_rain_heavy),
    SNOW_FALL_LIGHT(R.string.snow_fall_l, setOf(71), R.drawable.snowfall_light),
    SNOW_FALL_MEDIUM(R.string.snow_fall_m, setOf(73), R.drawable.snowfall_medium),
    SNOW_FALL_HEAVY(R.string.snow_fall_h, setOf(75), R.drawable.snowfall_heavy),
    SNOW_GRAINS(R.string.snow_grains, setOf(77), R.drawable.snow_grains),
    RAIN_SHOWERS_LIGHT(R.string.rain_showers_l, setOf(80), R.drawable.rain_shower_light),
    RAIN_SHOWERS_MEDIUM(R.string.rain_showers_m, setOf(81), R.drawable.rain_shower_medium),
    RAIN_SHOWERS_HEAVY(R.string.rain_showers_h, setOf(82), R.drawable.rain_shower_heavy),
    SNOW_SHOWERS_LIGHT(R.string.snow_showers_l, setOf(85), R.drawable.snow_shower_light),
    SNOW_SHOWERS_HEAVY(R.string.snow_showers_h, setOf(86), R.drawable.snow_shower_heavy),
    THUNDERSTORM(R.string.thunderstorm, setOf(95), R.drawable.thunderstorm),
    THUNDERSTORM_WITH_HAIL_LIGHT(R.string.thunderstorm_hail_l, setOf(96), R.drawable.thunderstorm_with_hail_light),
    THUNDERSTORM_WITH_HAIL_HEAVY(R.string.thunderstorm_hail_h, setOf(99), R.drawable.thunderstorm_with_hail_heavy),
    UNKNOWN(R.string.unknown_weather, setOf(-1), R.drawable.unknown_weather);

    companion object {
        fun getWeatherType(mtoCode: Int) = entries.firstOrNull { it.iconCode.contains(mtoCode) } ?: UNKNOWN
    }
}