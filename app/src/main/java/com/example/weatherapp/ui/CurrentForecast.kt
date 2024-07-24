package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.City
import com.example.weatherapp.data.WeatherIcons

@Composable
fun CurrentDay(city: City, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = city.name,
            style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.ExtraBold),
            modifier = modifier.fillMaxWidth()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "${city.weatherData.current.temperature_2m.toInt()}°",
                style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Image(
                painterResource(WeatherIcons.getWeatherType(city.weatherData.current.weather_code).iconImg),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}