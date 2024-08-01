package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.Utils.getDayOfWeek
import com.example.weatherapp.data.Day
import com.example.weatherapp.data.WeatherIcons
import java.time.format.TextStyle

@Composable
fun DailyCard(day: Day, modifier: Modifier = Modifier) {
    Column {
        Row(modifier = modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(0.6F)) {
                Text(
                    text = getDayOfWeek(day.time, LocalContext.current, TextStyle.FULL_STANDALONE),
                    style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Medium),
                )
                Text(
                    text = LocalContext.current.getString(WeatherIcons.getWeatherType(day.weather_code).iconNameRes),
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
                )
                Text(
                    text = LocalContext.current.getString(R.string.min_max_temperature, day.temperature_2m_min.toInt(), day.temperature_2m_max.toInt()),
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Light),
                )
            }
            Image(
                painter = painterResource(WeatherIcons.getWeatherType(day.weather_code).iconImg),
                contentDescription = null,
                modifier = Modifier.size(100.dp).weight(0.4F)
            )
        }
        HourlyForecast(day.hours)
    }
}