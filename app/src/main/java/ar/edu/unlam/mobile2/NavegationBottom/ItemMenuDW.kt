package ar.edu.unlam.mobile2.NavegationBottom

import ar.edu.unlam.mobile2.R


sealed class ItemMenuDW(
    val icono: Int,
    val titulo: String,
    val ruta: String,

    ) {

    object PantallaGoogle : ItemMenuDW(R.drawable.baseline_star_24, "Ubicacion","pantallaGoogle")

}


