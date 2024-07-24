package com.example.weatherapp.data

data class WeatherData(
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
    val daily_units: DailyUnits,
    val days: List<Day>
)

data class Day(
    val time: String,
    val weather_code: Int,
    val temperature_2m_max: Double,
    val temperature_2m_min: Double,
    val sunrise: String,
    val sunset: String,
    val uv_index_max: Double,
    val precipitation_hours: Double,
    val precipitation_probability_max: Int,
    val wind_speed_10m_max: Double,
    val wind_direction_10m_dominant: Int,
    val hours: List<Hour>
)

data class Hour(
    val time: String,
    val temperature_2m: Double,
    val apparent_temperature: Double,
    val precipitation_probability: Int,
    val weather_code: Int,
    val wind_speed_10m: Double,
    val wind_direction_10m: Int,
    val uv_index: Double
)

fun transformWeatherData(oldData: ReceivedWeatherData): WeatherData {
    val days = oldData.daily.time.mapIndexed { index, date ->
        Day(
            time = date,
            weather_code = oldData.daily.weather_code[index],
            temperature_2m_max = oldData.daily.temperature_2m_max[index],
            temperature_2m_min = oldData.daily.temperature_2m_min[index],
            sunrise = oldData.daily.sunrise[index],
            sunset = oldData.daily.sunset[index],
            uv_index_max = oldData.daily.uv_index_max[index],
            precipitation_hours = oldData.daily.precipitation_hours[index],
            precipitation_probability_max = oldData.daily.precipitation_probability_max[index],
            wind_speed_10m_max = oldData.daily.wind_speed_10m_max[index],
            wind_direction_10m_dominant = oldData.daily.wind_direction_10m_dominant[index],
            hours = oldData.hourly.time.filter { it.startsWith(date) }.mapIndexed { hourIndex, time ->
                Hour(
                    time = time,
                    temperature_2m = oldData.hourly.temperature_2m[hourIndex],
                    apparent_temperature = oldData.hourly.apparent_temperature[hourIndex],
                    precipitation_probability = oldData.hourly.precipitation_probability[hourIndex],
                    weather_code = oldData.hourly.weather_code[hourIndex],
                    wind_speed_10m = oldData.hourly.wind_speed_10m[hourIndex],
                    wind_direction_10m = oldData.hourly.wind_direction_10m[hourIndex],
                    uv_index = oldData.hourly.uv_index[hourIndex]
                )
            }
        )
    }

    return WeatherData(
        latitude = oldData.latitude,
        longitude = oldData.longitude,
        generationtime_ms = oldData.generationtime_ms,
        utc_offset_seconds = oldData.utc_offset_seconds,
        timezone = oldData.timezone,
        timezone_abbreviation = oldData.timezone_abbreviation,
        elevation = oldData.elevation,
        current_units = oldData.current_units,
        current = oldData.current,
        hourly_units = oldData.hourly_units,
        daily_units = oldData.daily_units,
        days = days
    )
}