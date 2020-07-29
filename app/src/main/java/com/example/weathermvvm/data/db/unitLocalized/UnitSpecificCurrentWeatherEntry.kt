package com.example.weathermvvm.data.db.unitLocalized

import com.google.gson.annotations.SerializedName

interface UnitSpecificCurrentWeatherEntry {

    val humidity: Int
    val isDay: String
    val pressure: Int
    val temperature: Int
    val uvIndex: Int
    val visibility: Int
    val weatherCode: Int
    val weatherDescriptions: List<String>
    val weatherIcons: List<String>
    val windDegree: Int
    val windDir: String
    val windSpeed: Int
}