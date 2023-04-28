package ar.edu.unlam.mobile2.data



import androidx.compose.runtime.Composable

import ar.edu.unlam.mobile2.domain.AppContainer


@Composable
fun General(){
    //AppContainer(ArticuloRepository.articuloApiModels)
}

@Composable
fun Politica() {
    //AppContainer(ArticuloRepository.articuloApiModels.filter { s: ArticuloApiModel -> s.topic.equals("Politica")})
}

@Composable
fun Musica() {
    //AppContainer(ArticuloRepository.articuloApiModels.filter { s: ArticuloApiModel -> s.topic.equals("Musica")})
}

