package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.unlam.mobile2.NavegationBottom.ItemMenuDW
import ar.edu.unlam.mobile2.NavegationBottom.ItemsMenu
import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherViewModel


@Composable
fun NavegationHost(navHostController: NavHostController, weatherViewModel: WeatherViewModel, viewModel: NewsViewModel) {

    NavHost(
        navController = navHostController,
        startDestination = ItemsMenu.Pantalla1.ruta,

        ){
        composable(ItemsMenu.Pantalla1.ruta){
            Inicio(weatherViewModel, viewModel)
        }
        composable(ItemsMenu.Pantalla2.ruta){
            Favorito(viewModel = viewModel)
        }
        composable(ItemsMenu.Pantalla3.ruta){
            Filtro(viewModel)
        }
        composable(ItemsMenu.Pantalla4.ruta){
            Anadir()
        }
        composable(ItemMenuDW.PantallaGoogle.ruta){
            MyGoogleMap()
        }

        }

    }
