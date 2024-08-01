package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.Hour
import com.example.weatherapp.data.WeatherIcons
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun HourlyForecast(hours: List<Hour>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(hours) { hour ->
            HourForecast(hour, Modifier.padding(horizontal = 20.dp))
        }
    }
}

@Composable
fun HourForecast(hour: Hour, modifier: Modifier = Modifier) {
    val hourTime = LocalDateTime.parse(hour.time).format(DateTimeFormatter.ofPattern("HH:mm"))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(hourTime)
        Image(
            painterResource(WeatherIcons.getWeatherType(hour.weather_code).iconImg),
            contentDescription = null,
            modifier = modifier.size(25.dp)
        )
        Text("${hour.temperature_2m.toInt()}°")
        PrecipitationProbability(hour.precipitation_probability)
    }
}

@Composable
fun PrecipitationProbability(precipitationProbability: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(Icons.Filled.WaterDrop, null, modifier = Modifier.size(15.dp))
        Text(
            text = "$precipitationProbability%",
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Light),
        )
    }
}