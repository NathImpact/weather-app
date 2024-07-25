package com.example.weatherapp.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weatherapp.WeatherScreen
import com.example.weatherapp.data.City

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    cities: MutableList<City>,
    navController: NavHostController
) {
    Scaffold(
        floatingActionButton = { AddCityButton { navController.navigate(WeatherScreen.CITY.name) } }
    ) { innerPadding ->
        val pagerState = rememberPagerState(pageCount = { cities.size })
        val scrollState = rememberScrollState()
        Column(Modifier.verticalScroll(scrollState)) {
            HorizontalPager(
                state  = pagerState,
                modifier = Modifier.padding(innerPadding)
            ) {
                if (cities.isNotEmpty()) CityForecast(cities[it])
            }
            Row(
                Modifier.padding(vertical = 10.dp).fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color(0xFF4d8fd1) else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AddCityButton(onAddButtonClick: () -> Unit) {
    IconButton(onClick = onAddButtonClick) {
        Icon(Icons.Filled.AddCircle, contentDescription = null, modifier = Modifier.size(50.dp))
    }
}
