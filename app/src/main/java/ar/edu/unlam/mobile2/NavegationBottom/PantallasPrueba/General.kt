package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.mediastackapi.ui.NewsList
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherScreen
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherViewModel

@Composable
fun Inicio (weatherViewModel: WeatherViewModel, viewModel: NewsViewModel,navController: NavHostController){

    Box(modifier = Modifier.fillMaxSize()) {
        NewsList(viewModel,0,navController)
        WeatherScreen(weatherViewModel)
    }
}