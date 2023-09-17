package ar.edu.unlam.mobile2

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.NavegationBottom.ItemsMenu
import ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba.NavegationHost
import ar.edu.unlam.mobile2.Tabs.repository.Tabs_item
import ar.edu.unlam.mobile2.Tabs.ui.Tabs
import ar.edu.unlam.mobile2.Tabs.ui.Tabs_content
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.weatherapi.ui.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val weatherViewModel by viewModels<WeatherViewModel>()
    private val newViewModel by viewModels<NewsViewModel>()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "719d2c40-5de1-44d8-980d-aded581ac26d",
            Analytics::class.java, Crashes::class.java
        )
        installSplashScreen()
        setContent {
            Mobile2_ScaffoldingTheme {
                notificationScreen()
                PantallaPrincipal(weatherViewModel = weatherViewModel, viewModel = newViewModel)
            }
        }
    }

}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun MyPreview() {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navegationItem = listOf(
        ItemsMenu.Pantalla1,
        ItemsMenu.Pantalla2,
        ItemsMenu.Pantalla3
    )

    Mobile2_ScaffoldingTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colorScheme.background,
            scaffoldState = scaffoldState,
            content = {
                Column(
                    Modifier
                        .fillMaxWidth()
                    /*.verticalScroll(rememberScrollState())*/
                ) {
                    TopAppBar(
                        title = {
                            Text(
                                text = "My App", color = Color.White, textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        },
                        backgroundColor = MaterialTheme.colorScheme.background
                    )
                    LazyColumn() {
                        items(100) {
                            Text(it.toString())
                        }
                    }
                }

            },
            bottomBar = { NavegacionInferior(navController, navegationItem) },
        )
    }


}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal(weatherViewModel: WeatherViewModel, viewModel: NewsViewModel) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navegationItem = listOf(
        ItemsMenu.Pantalla1,
        ItemsMenu.Pantalla2,
        ItemsMenu.Pantalla3
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colorScheme.background,
        scaffoldState = scaffoldState,
        content = {
            Column(
                Modifier
                    .fillMaxSize(),
                /*.verticalScroll(rememberScrollState())*/
            ) {
                TopAppBar(
                    backgroundColor = MaterialTheme.colorScheme.background
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .padding(start = 5.dp)
                            .clickable { navController.navigate("Pantalla1") },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.unlam_blanco),
                            tint = Color.White,
                            contentDescription = "Logo-Unlam-Blanco",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "UNLaM News",
                            color = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.align(CenterVertically)
                        )
                    }
                }
                NavegationHost(
                    navHostController = navController,
                    weatherViewModel = weatherViewModel,
                    viewModel = viewModel
                )
            }
        },
        bottomBar = { NavegacionInferior(navController, navegationItem) },
        floatingActionButton = { BotonFlotante(navController)},
    )
}

/*@Composable
fun BotonFlotante(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController
){
    FloatingActionButton(
          modifier = Modifier.size(50.dp,50.dp),
          containerColor = MaterialTheme.colorScheme.primary,
          onClick = {navController.navigate("pantalla4");
              scope.launch { scaffoldState.snackbarHostState.showSnackbar("Agregar noticia"
              ,actionLabel = "Aceptar"
              ,duration = SnackbarDuration.Short
              )}},)
      {
          Icon(
              imageVector = Icons.Filled.Add,
              contentDescription = "Anadir",
              tint = Color.Black)

    }
}*/

@Composable
fun BotonFlotante(navController: NavHostController){

      FloatingActionButton(
          modifier = Modifier.size(50.dp,50.dp),
          containerColor = MaterialTheme.colorScheme.primary,
          onClick = {navController.navigate("pantalla4")},)
      {
          Icon(
              imageVector = Icons.Filled.Add,
              contentDescription = "Anadir",
              tint = Color.Black)
      }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun notificationScreen(){
    val permissionState = rememberPermissionState(permission = android.Manifest.permission.POST_NOTIFICATIONS)

    LaunchedEffect(key1 = true){
        permissionState.launchPermissionRequest()
    }

    if(permissionState.status.isGranted){
        Text(text = "Permiso concedido")
    } else{
        Text(text = "El permiso fue denegado")
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavegacionInferior(navController: NavHostController, menuItem: List<ItemsMenu>) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.onBackground
    ) {
        BottomNavigation(backgroundColor = MaterialTheme.colorScheme.onBackground) {
            val currentRoute = currentRoute(navController = navController)
            menuItem.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.ruta,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icono),
                            contentDescription = item.titulo,
                            tint = (if (currentRoute == item.ruta) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                Color.White
                            })
                        )
                    },
                    //label = { Text(item.titulo, color = Color.White) }
                )


            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs_Principal(viewModel: NewsViewModel) {
    val tabs = listOf(
        Tabs_item.item_general(viewModel),
        Tabs_item.item_business(viewModel),
        Tabs_item.item_entertainment(viewModel),
        Tabs_item.item_health(viewModel),
        Tabs_item.item_science(viewModel),
        Tabs_item.item_sports(viewModel),
        Tabs_item.item_technology(viewModel)


    )
    val pagerState = rememberPagerState()
    Column() {
        Tabs(tabs, pagerState)
        Tabs_content(tabs, pagerState)
    }
}
