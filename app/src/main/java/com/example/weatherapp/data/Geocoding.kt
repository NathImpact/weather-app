package com.example.weatherapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FeatureCollection(
    val type: String,
    val version: String,
    val features: List<Feature>,
    val attribution: String,
    val licence: String,
    val query: String,
    val filters: Map<String, String>,
    val limit: Int
)

@Serializable
data class Geometry(
    val type: String,
    val coordinates: List<Double>
)

@Serializable
data class Properties(
    val label: String,
    val score: Double,
    val id: String,
    val type: String,
    val name: String,
    @SerialName("postcode") val postCode: String,
    @SerialName("citycode") val cityCode: String,
    val x: Double,
    val y: Double,
    val population: Int,
    val city: String,
    val context: String,
    val importance: Double,
    val municipality: String,
    val banId: String? = null
)

@Serializable
data class Feature(
    val type: String,
    val geometry: Geometry,
    val properties: Properties
)

data class Point(
    val lat: Double,
    val lon: Double
)

fun getCitiesFromFeatures(featureCollection: FeatureCollection): List<City> {
    val cityList = mutableListOf<City>()
    featureCollection.features.forEach {
        cityList.add(
            City(
                it.properties.city,
                Point(it.geometry.coordinates[1], it.geometry.coordinates[0])
            )
        )
    }
    return cityList
}