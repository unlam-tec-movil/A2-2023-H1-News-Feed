package ar.edu.unlam.mobile2.mediastackapi

import ar.edu.unlam.mobile2.mediastackapi.data.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MediastackApi {

    @GET("v1/news")
    suspend fun getNews(
        @Query("access_key") apiKey: String = "33597a00a28ca90e3e5ac791b76b3e6e"
    ): NewsResponse
}