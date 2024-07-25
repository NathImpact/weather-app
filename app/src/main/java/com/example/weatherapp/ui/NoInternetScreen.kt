package com.example.weatherapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.weatherapp.Utils

@Composable
fun NoInternetScreen(onReloadClick: (Boolean) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        Text("No Internet", style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.ExtraBold))
        Icon(painterResource(R.drawable.no_internet), "noInternetIcon")
        IconButton(
            onClick = { onReloadClick(Utils.isInternetAvailable(context)) }
        ) {
            Icon(Icons.Filled.Refresh, null, modifier = Modifier.size(150.dp))
        }
    }
}