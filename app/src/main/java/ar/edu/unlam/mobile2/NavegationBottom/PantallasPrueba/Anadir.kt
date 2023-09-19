package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anadir(navController: NavHostController) {

    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }

    Column() {


    // Barra superior


    TopAppBar(

        title = { Text(text = "") },
        backgroundColor = Color.DarkGray,
        modifier = Modifier
            .fillMaxWidth(),

        actions = {
            Button(
                onClick = {
                    // Acción cuando se hace clic en el botón
                },
                modifier = Modifier.padding(end = 16.dp) // Espacio entre el botón y el borde derecho
            ) {
                Text(text = "publicar")
            }
        }
    )
    Spacer(modifier = Modifier.height(15.dp))
    Text(

        text = "Titulo",
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier
            .padding(start = 16.dp)

    )

    Spacer(modifier = Modifier.height(5.dp))

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = {
            Text("Ingrese el Titulo")
        },
        modifier = Modifier
            .padding(16.dp)
            .size(height = 50.dp, width = 600.dp)
    )

    Text(

        text = "Descripcion",
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier
            .padding(start = 16.dp)

    )

    Spacer(modifier = Modifier.height(5.dp))

    TextField(
        value = text2,
        onValueChange = {
            text2 = it
        },

        modifier = Modifier
            .padding(16.dp)
            .size(height = 130.dp, width = 600.dp)
    )

    Row(){

        Text(
            text = "Categoria",
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .padding(start = 16.dp))

        Text(
            text = "Pais",
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .padding(start = 130.dp))



    }

    Row(){

        TextField(
            value = text3,
            onValueChange = {
                text3 = it
            },
            modifier = Modifier
                .padding(16.dp)
                .size(height = 50.dp, width = 170.dp)
        )

        TextField(
            value = text4,
            onValueChange = {
                text4 = it
            },
            modifier = Modifier
                .padding(16.dp)
                .size(height = 50.dp, width = 170.dp)
        )



    }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.Gray // Puedes personalizar el color de la línea
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ){
        FloatingActionButton(
            modifier = Modifier
                .size(100.dp, 100.dp)
                .padding(16.dp)
                ,

            containerColor = MaterialTheme.colorScheme.primary,
            onClick = {

            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription = "Camara",
                tint = Color.Black
            )

        }}

}


}

