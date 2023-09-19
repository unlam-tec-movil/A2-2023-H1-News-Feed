package ar.edu.unlam.mobile2.mediastackapi.ui



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel
import ar.edu.unlam.mobile2.theme.Mobile2_ScaffoldingTheme

@Preview(showSystemUi = true)
@Composable
fun MySavedNewsPreview() {
    Mobile2_ScaffoldingTheme() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "No hay noticias marcadas.", style = MaterialTheme.typography.titleLarge ,color = MaterialTheme.colorScheme.onBackground)
        }
    }

}


@Composable
fun SavedNewsList(viewModel: NewsViewModel,navController: NavHostController) {
    val listaNoticias by viewModel.listaNoticias.observeAsState(emptyList())
    val context = LocalContext.current
    val savedNewsSize = getSavedNewsCount(listaNoticias)

    if (savedNewsSize != 0) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listaNoticias.filter { it.saved }) { item ->
                NewDesign(noticia = item, onItemClick = { nuevoItem ->
                    viewModel.actualizarItem(nuevoItem)
                },
                    onItemClick2 = {

                        viewModel.enviarNotica(item)
                        navController.navigate("pantalla5")
                    })
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "No hay noticias marcadas.", style = MaterialTheme.typography.titleLarge ,color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

fun getSavedNewsCount(lista: List<New>): Int {
    return lista.filter { it.saved }.size
}


