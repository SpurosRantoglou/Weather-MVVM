package com.example.weathermvvm.data.db.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weathermvvm.data.WeatherApiService
import com.example.weathermvvm.data.db.network.response.CurrentWeatherResponse
import com.example.weathermvvm.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
        private val apiService: WeatherApiService
    ) : WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadCurrentWeather

    override suspend fun fetchCurrentWeather(location: String) {
        try {
            val fetchedCurrentWeather = apiService
                .getCurrentWeather(location)
                .await()

            _downloadCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e: NoConnectivityException){
            Log.e("Connectivity", "Δεν έχετε συνδεθεί σε κάποιο δίκτυο")
        }
    }
}