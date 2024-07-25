package com.example.weatherapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.City
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun CityForecast(
    city: City,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        CurrentDay(city, modifier)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        HourlyForecast(
            hours = city.weatherData.days[0].hours.dropWhile { LocalDateTime.now().hour - LocalDateTime.parse(it.time, formatter).hour > 0 },
            modifier = modifier
                .padding(horizontal = 5.dp, vertical = 10.dp)
                .background(
                    Color(0x337EAFE0),
                    RoundedCornerShape(15.dp)
                )
            )
        DailyForecast(
            city.weatherData.days,
            modifier
                .padding(horizontal = 5.dp, vertical = 10.dp)
                .background(
                    Color(0x337EAFE0),
                    RoundedCornerShape(15.dp)
                )
        )
    }
}