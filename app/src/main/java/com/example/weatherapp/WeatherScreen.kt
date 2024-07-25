package com.example.weatherapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.Utils.isInternetAvailable
import com.example.weatherapp.data.City
import com.example.weatherapp.ui.CityChooserScreen
import com.example.weatherapp.ui.HomeScreen
import com.example.weatherapp.ui.NoInternetScreen

enum class WeatherScreen {
    HOME,
    CITY,
    NO_INTERNET
}

val cities = mutableStateListOf<City>()

@Composable
fun WeatherApp(
    navController: NavHostController = rememberNavController()
) {
    Surface {
        NavHost(
            navController = navController,
            startDestination = if (isInternetAvailable(LocalContext.current)) WeatherScreen.HOME.name else WeatherScreen.NO_INTERNET.name,
            modifier = Modifier.fillMaxWidth()
        ) {
            composable(route = WeatherScreen.HOME.name) {
                HomeScreen(cities, navController)
            }
            composable(route = WeatherScreen.CITY.name) {
                CityChooserScreen(onCitySelected = { onCityAdded(it, navController, cities) })
            }
            composable(route = WeatherScreen.NO_INTERNET.name) {
                NoInternetScreen(onReloadClick = { if (it) navController.navigate(WeatherScreen.HOME.name) })
            }
        }
    }
}

private fun onCityAdded(city: City, navController: NavHostController, cities: SnapshotStateList<City>) {
    navController.navigate(WeatherScreen.HOME.name)
    cities.add(city)
}