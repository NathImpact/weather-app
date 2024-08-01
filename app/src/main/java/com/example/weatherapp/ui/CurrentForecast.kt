package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.example.weatherapp.data.City
import com.example.weatherapp.data.WeatherIcons

@Composable
fun CurrentDay(city: City, modifier: Modifier = Modifier) {
    val currentWeather = city.weatherData.current
    val dayWeather = city.weatherData.days[0]
    Column {
        Row(modifier = modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(0.7F)) {
                Text(
                    text = city.name,
                    style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.ExtraBold),
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    text = "${currentWeather.temperature_2m.toInt()}°",
                    style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.SemiBold)
                )
            }
            Image(
                painterResource(WeatherIcons.getWeatherType(currentWeather.weather_code).iconImg),
                contentDescription = null,
                modifier = Modifier.size(100.dp).weight(0.3F)
            )
        }
        Text(
            text = LocalContext.current.getString(WeatherIcons.getWeatherType(currentWeather.weather_code).iconNameRes),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
        )
        Text(
            text = LocalContext.current.getString(R.string.current_temperature, dayWeather.temperature_2m_min.toInt(), dayWeather.temperature_2m_max.toInt(), currentWeather.apparent_temperature.toInt()),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Light),
        )
    }
}