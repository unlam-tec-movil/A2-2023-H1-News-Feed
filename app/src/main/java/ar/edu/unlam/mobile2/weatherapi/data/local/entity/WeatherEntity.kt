package ar.edu.unlam.mobile2.weatherapi.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val cloudcover: Int,
    val feelslike: Int,
    val humidity: Int,
    val observationTime: String,
    val precip: Int,
    val pressure: Int,
    val temperature: Int,
    val uvIndex: Int,
    val visibility: Int,
    val weatherCode: Int,
    val weatherDescriptions: List<String>,
    val weatherIcons: List<String>,
    val windDegree: Int,
    val windDir: String,
    val windSpeed: Int,
)