package ar.edu.unlam.mobile2.weatherapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

import ar.edu.unlam.mobile2.weatherapi.data.local.entity.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract val dao: WeatherDao
}