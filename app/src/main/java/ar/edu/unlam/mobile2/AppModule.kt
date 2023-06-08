package ar.edu.unlam.mobile2

import android.app.Application
import androidx.room.Room
import ar.edu.unlam.mobile2.mediastackapi.GetNews
import ar.edu.unlam.mobile2.mediastackapi.data.api.MediastackApi
import ar.edu.unlam.mobile2.mediastackapi.data.NewRepository
import ar.edu.unlam.mobile2.mediastackapi.data.local.NewDao
import ar.edu.unlam.mobile2.mediastackapi.data.local.NewDatabase
import ar.edu.unlam.mobile2.weatherapi.data.api.WeatherApiService
import ar.edu.unlam.mobile2.weatherapi.repository.WeatherStackRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //Mediastack Api
    @Provides
    @Singleton
    fun provideMediaStackApi(): MediastackApi {
        return Retrofit.Builder().baseUrl("http://api.mediastack.com/")
                .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder().build())
                .build().create(MediastackApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewDao(application: Application): NewDao{
        val db = Room.databaseBuilder(application, NewDatabase::class.java,"news_db").build()
        return db.dao
    }

    @Provides
    @Singleton
    fun provideMediastackRepository(api: MediastackApi, dao: NewDao): NewRepository {
        return NewRepository(api, dao)
    }

    @Provides
    @Singleton
    fun provideGetCharacters(repository: NewRepository): GetNews{
        return GetNews(repository)
    }

    //Weather Api

    @Provides
    @Singleton
    fun provideWeatherApi (): WeatherApiService {
        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository (api: WeatherApiService): WeatherStackRepository {
        return WeatherStackRepository(api)
    }
}