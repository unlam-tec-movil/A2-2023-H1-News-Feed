package ar.edu.unlam.mobile2.weatherapi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import ar.edu.unlam.mobile2.weatherapi.data.local.entity.WeatherEntity

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserWeather(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM WeatherEntity")
    suspend fun getWeather(): WeatherEntity
}