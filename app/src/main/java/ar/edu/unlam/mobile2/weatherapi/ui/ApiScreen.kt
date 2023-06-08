package ar.edu.unlam.mobile2.weatherapi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.weatherapi.data.api.response.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun WeatherScreen(weatherViewModel: WeatherViewModel) {
    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }

    LaunchedEffect(Unit) {
        val data = withContext(Dispatchers.IO) {
            weatherViewModel.getWeatherData("Buenos Aires")
        }
        weatherData = data
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        if (weatherData != null) {
            Text(
                text = "Temperature: ${weatherData!!.current.temperature}",
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Weather Description: ${weatherData!!.current.weatherDescriptions.first()}",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        } else {
            Text("Loading weather data...")
        }
    }
}