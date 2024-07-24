package com.example.weatherapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.Utils
import com.example.weatherapp.data.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun CityMainSurface(onCitySelected: (City)-> Unit, modifier: Modifier = Modifier) {
    Surface {
        var cityName by remember { mutableStateOf("") }
        var searchResults by remember { mutableStateOf<List<City>>(emptyList()) }

        LaunchedEffect(cityName) {
            searchResults = (if (cityName.length > 2) {
                withContext(Dispatchers.IO) {
                    Utils.connector.getGeocodingData(cityName, numberOfResults = 10)
                } ?: emptyList()
            } else emptyList())
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = cityName,
                onValueChange = { cityName = it },
                label = { Text("Nom de la Ville") },
                modifier = Modifier.fillMaxWidth()
            )

            searchResults.forEach { city ->
                Text(
                    text = city.name,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { runCatching { onCitySelected(city) }  }
                )
            }
        }
    }
}