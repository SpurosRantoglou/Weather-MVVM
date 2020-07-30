package com.example.weathermvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weathermvvm.data.db.entity.CURRENT_WEATHER_ID
import com.example.weathermvvm.data.db.entity.CurrentWeatherEntry
import com.example.weathermvvm.data.db.unitLocalized.ImperialCurrentWeatherEntry
import com.example.weathermvvm.data.db.unitLocalized.UnitSpecificCurrentWeatherEntry

@Dao
interface CurrentWeatherDAO {
    //Update and Insert at the same time
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    //Now we can create function about getting only C or F, depents on user preferences
    //That's why if we want we create different classes Imperial CurrentWeatherEntry etc
    @Query("select * from current_weather wher id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}