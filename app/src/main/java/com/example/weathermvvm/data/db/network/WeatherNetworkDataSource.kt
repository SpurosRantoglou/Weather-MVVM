package com.example.weathermvvm.data.db.network

import androidx.lifecycle.LiveData
import com.example.weathermvvm.data.db.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
     )
}