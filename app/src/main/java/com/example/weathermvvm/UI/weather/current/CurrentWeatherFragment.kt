package com.example.weathermvvm.UI.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.weathermvvm.R
import com.example.weathermvvm.data.WeatherApiService
import com.example.weathermvvm.data.db.network.ConnectivityInterceptorImpl
import com.example.weathermvvm.data.db.network.WeatherNetworkDataSource
import com.example.weathermvvm.data.db.network.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val apiService = WeatherApiService(ConnectivityInterceptorImpl(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadCurrentWeather.observe(this, Observer {
            city.text = it.location.name.toString()
            country.text = it.location.country.toString()
            date.text = it.location.localtime.toString()
            temperature.text = it.currentWeatherEntry.temperature.toString() + "°C"
            humidity.text = it.currentWeatherEntry.humidity.toString() + "%"
            wind.text = it.currentWeatherEntry.windSpeed.toString() +" km/hr"
            pressure.text = it.currentWeatherEntry.pressure.toString()
        })

        GlobalScope.launch(Dispatchers.Main) {
            weatherNetworkDataSource.fetchCurrentWeather("Athens")


        }

    }

}