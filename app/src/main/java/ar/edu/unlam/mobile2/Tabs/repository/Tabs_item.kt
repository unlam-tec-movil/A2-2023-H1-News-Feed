package ar.edu.unlam.mobile2.Tabs.repository

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel


typealias miFuncion = @Composable () -> Unit

sealed class Tabs_item(
    var icon: Int,
    var title: String,
    var screen: miFuncion,

) {
    class item_general(viewModel:NewsViewModel,navController: NavHostController) :
        Tabs_item(R.drawable.ic_launcher_foreground, "General", { General(viewModel,navController) })

    class item_business(viewModel: NewsViewModel,navController: NavHostController) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Business", { Business(viewModel,navController) })

    class item_entertainment(viewModel: NewsViewModel,navController: NavHostController) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Entertainment", { Entertainment(viewModel,navController) })
    class item_health(viewModel: NewsViewModel,navController: NavHostController) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Health", { Health(viewModel,navController) })

    class item_science(viewModel: NewsViewModel,navController: NavHostController) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Science", { Science(viewModel,navController) })

    class item_sports(viewModel: NewsViewModel,navController: NavHostController) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Sports", { Sports(viewModel,navController) })

    class item_technology(viewModel: NewsViewModel,navController: NavHostController) :
        Tabs_item(R.drawable.ic_launcher_foreground, "Technology", { Technology(viewModel,navController) })



}
