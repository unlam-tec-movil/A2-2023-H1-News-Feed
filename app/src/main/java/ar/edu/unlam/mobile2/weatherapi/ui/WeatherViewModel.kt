package ar.edu.unlam.mobile2.weatherapi.ui


import androidx.lifecycle.ViewModel
import ar.edu.unlam.mobile2.weatherapi.repository.WeatherStackRepository
import ar.edu.unlam.mobile2.weatherapi.data.api.response.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherStackRepository,
) : ViewModel() {

    suspend fun getWeatherData(location: String): WeatherResponse {
        return repository.getWeatherData(location)
    }
}
