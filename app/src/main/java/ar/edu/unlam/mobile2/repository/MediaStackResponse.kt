package ar.edu.unlam.mobile2.repository

import ar.edu.unlam.mobile2.data.ArticuloApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MediaStackResponse(
    val data: List<ArticuloApiModel>
) {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://api.mediastack.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mediaStackApi = retrofit.create(MediaStackApi::class.java)
    val call = mediaStackApi.getNews(
        "5e48b03cc3ee66a83b4478052ef16fb3",
        "author",
        "title",
        "description",
        "source",
        "image",
        "category",
        "ar",
        "published_at"
    )


}



