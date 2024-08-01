package com.example.weatherapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.weatherapp.data.Connector
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle

object Utils {
    val connector = Connector()

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
    }

    fun getDayOfWeek(dateStr: String, context: Context, textStyle:TextStyle = TextStyle.SHORT_STANDALONE): String {
        val currentLocale = context.resources.configuration.locales[0]
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val todayDate = LocalDate.parse(LocalDate.now().toString(), formatter)
        val date = LocalDate.parse(dateStr, formatter)

        return if (todayDate == date) {
            context.getString(R.string.today)
        } else {
            date.dayOfWeek.getDisplayName(textStyle, currentLocale)
        }
    }
}