package ar.edu.unlam.mobile2.weatherapi.repository

import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse

class WeatherStackRepository(private val api: WeatherApiService) {

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "66ac0662f66cbb355fa608bbc1cbea5a"
        return api.getCurrentWeather(apiKey, location)
    }
}
