package com.example.weatherapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.Utils.isInternetAvailable
import com.example.weatherapp.data.City
import com.example.weatherapp.ui.CityMainSurface
import com.example.weatherapp.ui.HomeScreen

enum class WeatherScreen(val title: String) {
    HOME("Home"),
    CITY("City"),
    NO_INTERNET("No Internet")
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
                CityMainSurface(onCitySelected = { onCityAdded(it, navController, cities) })
            }
            composable(route = WeatherScreen.NO_INTERNET.name) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Text("No Internet")
                    Icon(painterResource(R.drawable.no_internet), null)
                }
            }
        }
    }
}

private fun onCityAdded(city: City, navController: NavHostController, cities: SnapshotStateList<City>) {
    navController.navigate(WeatherScreen.HOME.name)
    cities.add(city)
}