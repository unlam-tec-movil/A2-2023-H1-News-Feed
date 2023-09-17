package ar.edu.unlam.mobile2.mediastackapi.data.api

import ar.edu.unlam.mobile2.mediastackapi.data.api.response.NewsResponse
import retrofit2.http.GET

interface MediastackApi {
    @GET("v1/news?access_key=2c405b47405099b5945c0b06699e127d" +
            "&limit=10")
    suspend fun getNews(
    ): NewsResponse
}