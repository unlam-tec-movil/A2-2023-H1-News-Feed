package ar.edu.unlam.mobile2.NavegationBottom

import ar.edu.unlam.mobile2.R

sealed class ItemsMenu(
    val icono: Int,
    val titulo: String,
    val ruta: String,

    ) {
    object Pantalla1 : ItemsMenu(R.drawable.baseline_language_24, "General", "pantalla1")
    object Pantalla2 : ItemsMenu(R.drawable.baseline_bookmarks_24, "Favoritos", "pantalla2")
    object Pantalla3 : ItemsMenu(R.drawable.baseline_filter_alt_24, "Filtrar", "pantalla3")
    object Pantalla4 : ItemsMenu(R.drawable.baseline_add_24, "Anadir", "pantalla4")
    object Pantalla5 : ItemsMenu(R.drawable.baseline_add_24, "NoticaScreen", "pantalla5")

}
