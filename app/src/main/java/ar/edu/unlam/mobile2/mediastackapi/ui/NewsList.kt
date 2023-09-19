package ar.edu.unlam.mobile2.mediastackapi.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba.NavegationHost


import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable
fun NewsList(viewModel: NewsViewModel, numero: Int,navController: NavHostController) {
    val listaNoticias by viewModel.listaNoticias.observeAsState(emptyList())
    val context = LocalContext.current

    val category = when (numero) {
        1 -> "general"
        2 -> "business"
        3 -> "entertainment"
        4 -> "health"
        5 -> "science"
        6 -> "sports"
        7 -> "technology"
        else -> {
            null
        }
    }

    if (listaNoticias.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            if (category == null) {
                items(listaNoticias) { item ->
                    NewDesign(noticia = item, onItemClick = { nuevoItem ->
                        viewModel.actualizarItem(nuevoItem)
                        viewModel.actualizarItemEnBase(nuevoItem)

                    },
                        onItemClick2 = {
                            viewModel.enviarNotica(item)
                            navController.navigate("pantalla5")
                            //NewDetailActivity.start(context, item)
                        })
                }
            } else {
                items(listaNoticias.filter { it.category == category }) { item ->
                    NewDesign(noticia = item, onItemClick = { nuevoItem ->
                        viewModel.actualizarItem(nuevoItem)
                        viewModel.actualizarItemEnBase(nuevoItem)
                    },

                        onItemClick2 = {
                            viewModel.enviarNotica(item)
                            navController.navigate("pantalla5")
                            //NewDetailActivity.start(context, item)
                        })
                }

            }
        }
    }

    /*LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(listaNoticias) { item ->
            when (numero) {
                0 ->
                    NewDesign(noticia = item, onItemClick = { nuevoItem ->
                        viewModel.actualizarItem(nuevoItem)
                        viewModel.actualizarItemEnBase(nuevoItem)

                    },
                        onItemClick2 = {
                            NewDetailActivity.start(context, item)
                        })

                1 ->
                    if (item.category.equals("general")) {
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        },
                            onItemClick2 = {
                                NewDetailActivity.start(context, item)
                            })
                    }

                2 ->
                    if (item.category.equals("business")) {
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        },
                            onItemClick2 = {
                                NewDetailActivity.start(context, item)
                            })
                    }

                3 ->
                    if (item.category.equals("entertainment")) {
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        },
                            onItemClick2 = {
                                NewDetailActivity.start(context, item)
                            })
                    }

                4 ->
                    if (item.category.equals("health")) {
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        },
                            onItemClick2 = {
                                NewDetailActivity.start(context, item)
                            })
                    }

                5 ->
                    if (item.category.equals("science")) {
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        },
                            onItemClick2 = {
                                NewDetailActivity.start(context, item)
                            })
                    }

                6 ->
                    if (item.category.equals("sports")) {
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        },
                            onItemClick2 = {
                                NewDetailActivity.start(context, item)
                            })
                    }

                7 ->
                    if (item.category.equals("technology")) {
                        NewDesign(noticia = item, onItemClick = { nuevoItem ->
                            viewModel.actualizarItem(nuevoItem)
                            viewModel.actualizarItemEnBase(nuevoItem)
                        },
                            onItemClick2 = {
                                NewDetailActivity.start(context, item)
                            })
                    }
            }

        }
    }*/
    else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()

            Log.d("Error en lista", "No hay datos para mostrar")
        }
    }

}