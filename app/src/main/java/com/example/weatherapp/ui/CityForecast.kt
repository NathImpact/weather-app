package com.example.weatherapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.City

@Composable
fun CityForecast(
    city: City,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        CurrentDay(city, modifier)
        HorizontalDivider(
            modifier.padding(horizontal = 15.dp, vertical = 25.dp).clip(RoundedCornerShape(15.dp)),
            thickness = 5.dp
        )
        DailyForecast(
            city.weatherData.days,
            modifier
                .padding()
                .background(
                    Color(0x337EAFE0),
                    RoundedCornerShape(15.dp)
                )
        )
    }
}