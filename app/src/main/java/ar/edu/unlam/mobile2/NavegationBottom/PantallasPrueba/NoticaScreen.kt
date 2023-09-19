package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import ar.edu.unlam.mobile2.mediastackapi.New
import ar.edu.unlam.mobile2.theme.Mobile2_ScaffoldingTheme

@Composable
fun NoticaScreen(new: New,navController: NavHostController) {
    PlantDetailScreen(new,navController)

}
    fun abrirLink(context: Context, link: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        context.startActivity(intent)
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun NewDetail(new: New) {
        val context = LocalContext.current
        Mobile2_ScaffoldingTheme {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                item {
                    Text(
                        text = new.title!!,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                item { Spacer(modifier = Modifier.height(5.dp)) }
                item {
                    Row {
                        Text(
                            text = new.source!!,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = new.category!!,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                item { Spacer(modifier = Modifier.height(15.dp)) }
                item {
                    Text(
                        text = new.description!!,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
                item { Spacer(modifier = Modifier.height(10.dp)) }
                item {
                    Button(
                        onClick = { abrirLink(context, new.url!!) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.primary)
                    ) {
                        androidx.compose.material.Text(
                            text = "Para ver la noticia completa, haga click aquí",
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }


            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun PlantDetailScreen(new: New, navController: NavHostController) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    backgroundColor = MaterialTheme.colorScheme.background
                )
            },
            backgroundColor = MaterialTheme.colorScheme.background,
            content = {
                NewDetail(new)
            }
        )
    }





