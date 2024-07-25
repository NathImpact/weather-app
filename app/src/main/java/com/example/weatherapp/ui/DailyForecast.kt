package com.example.weatherapp.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.Day
import com.example.weatherapp.data.WeatherIcons
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle

@Composable
fun DailyForecast(days: List<Day>, modifier: Modifier = Modifier) {
    val daysIterator = days.drop(0).iterator()
    Column(modifier = modifier) {
        while (daysIterator.hasNext()) {
            DailyForecastItem(daysIterator.next())
            if (daysIterator.hasNext()) HorizontalDivider(
                modifier = Modifier.padding(horizontal = 5.dp),
                thickness = 2.dp
            )
        }
    }
}

@Composable
fun DailyForecastItem(day: Day, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = getDayOfWeek(day.time, LocalContext.current), modifier.weight(1F))
        Image(
            painterResource(WeatherIcons.getWeatherType(day.weather_code).iconImg),
            contentDescription = null,
            modifier = Modifier.size(50.dp).weight(1F)
        )
        Text(text = "${day.temperature_2m_min.toInt()}/${day.temperature_2m_max.toInt()}°C", modifier.weight(1F))
        WindSpeed(day.wind_direction_10m_dominant.toFloat(), day.wind_speed_10m_max.toInt(), modifier.weight(1F))
    }
}

@Composable
fun WindSpeed(direction: Float, speed: Int, modifier: Modifier) {
    Row(modifier) {
        println(direction)
        Icon(
            Icons.AutoMirrored.Rounded.ArrowForward,
            contentDescription = null,
            modifier = Modifier.rotate(direction)
        )
        Text(text = "${speed}km/h")
    }
}

private fun getDayOfWeek(dateStr: String, context: Context): String {
    val currentLocale = context.resources.configuration.locales[0]
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val todaysDate = LocalDate.parse(LocalDate.now().toString(), formatter)
    val date = LocalDate.parse(dateStr, formatter)

    return if (todaysDate == date) {
        context.getString(R.string.today)
    } else {
        date.dayOfWeek.getDisplayName(TextStyle.FULL_STANDALONE, currentLocale)
    }
}