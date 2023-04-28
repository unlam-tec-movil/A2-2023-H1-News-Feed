package ar.edu.unlam.mobile2.repository


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MediaStackRestRepo {

    private val mediaStackApiService = Retrofit.Builder()
        .baseUrl("http://api.mediastack.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MediaStackApi::class.java)

    suspend fun getNews(): List<ArticuloApiModel> {
        val response = mediaStackApiService.getNews(
            accessKey = "e3d512ec83d672a7e4da8962c1824f10",
            language = "es",
        )
        return response.data
    }
}
