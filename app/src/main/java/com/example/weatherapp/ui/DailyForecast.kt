package com.example.weatherapp.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.weatherapp.Utils.getDayOfWeek
import com.example.weatherapp.data.Day
import com.example.weatherapp.data.WeatherIcons

private val showDialog = mutableStateOf(false)
private val dayState = mutableStateOf<Day?>(null)

@Composable
fun DailyForecast(days: List<Day>, modifier: Modifier = Modifier) {
    val daysIterator = days.iterator()
    Column(modifier = modifier) {
        while (daysIterator.hasNext()) {
            DailyForecastItem(daysIterator.next())
            if (daysIterator.hasNext()) HorizontalDivider(
                modifier = Modifier.padding(horizontal = 5.dp),
                thickness = 2.dp
            )
        }
    }
    AnimatedVisibility(showDialog.value) { MinimalDialog() }
}

@Composable
fun DailyForecastItem(day: Day, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { showDialog.value = true ; dayState.value = day }
    ) {
        Text(text = getDayOfWeek(day.time, LocalContext.current), modifier.weight(0.2F))
        PrecipitationProbability(day.precipitation_probability_max, modifier.weight(0.15F))
        Image(
            painterResource(WeatherIcons.getWeatherType(day.weather_code).iconImg),
            contentDescription = null,
            modifier = Modifier.size(30.dp).weight(0.2F)
        )
        Text(text = "${day.temperature_2m_min.toInt()}/${day.temperature_2m_max.toInt()}°C", modifier.weight(0.2F))
        WindSpeed(day.wind_direction_10m_dominant.toFloat(), day.wind_speed_10m_max.toInt(), modifier.weight(0.25F))
    }
}

@Composable
fun WindSpeed(direction: Float, speed: Int, modifier: Modifier) {
    Row(modifier.fillMaxWidth()) {
        Icon(
            Icons.AutoMirrored.Rounded.ArrowForward,
            contentDescription = null,
            modifier = modifier.rotate(direction)
        )
        Text(text = "${speed}km/h")
    }
}



@Composable
fun MinimalDialog() {
    dayState.value?.also {
        Dialog({ showDialog.value = false }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                DailyCard(it)
            }
        }
    }
}