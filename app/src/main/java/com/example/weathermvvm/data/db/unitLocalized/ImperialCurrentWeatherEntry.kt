package com.example.weathermvvm.data.db.unitLocalized

import androidx.room.ColumnInfo

data class ImperialCurrentWeatherEntry (
    @ColumnInfo(name = "humidity")
    override val humidity: Int,
    @ColumnInfo(name = "isDay")
    override val isDay: String,
    @ColumnInfo(name = "pressure")
    override val pressure: Int,
    @ColumnInfo(name = "temperature")
    override val temperature: Int,
    @ColumnInfo(name = "uvIndex")
    override val uvIndex: Int,
    @ColumnInfo(name = "visibility")
    override val visibility: Int,
    @ColumnInfo(name = "weatherCode")
    override val weatherCode: Int,
    @ColumnInfo(name = "weatherDescriptions")
    override val weatherDescriptions: List<String>,
    @ColumnInfo(name = "weatherIcons")
    override val weatherIcons: List<String>,
    @ColumnInfo(name = "windDegree")
    override val windDegree: Int,
    @ColumnInfo(name = "windDir")
    override val windDir: String,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Int

) : UnitSpecificCurrentWeatherEntry