package ar.edu.unlam.mobile2.mediastackapi.data.api

import ar.edu.unlam.mobile2.mediastackapi.data.api.response.NewsResponse
import retrofit2.http.GET

interface MediastackApi {
    @GET("v1/news?access_key=2f8c261526cecda76ad801409e554506" +
            "&limit=10")
    suspend fun getNews(
    ): NewsResponse
}