package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import ar.edu.unlam.mobile2.Tabs_Principal
import ar.edu.unlam.mobile2.mediastackapi.ui.NewsList
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherScreen
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherViewModel

@Composable
fun Filtro (viewModel:NewsViewModel,navController: NavHostController){
    Tabs_Principal(viewModel,navController)
}

