package ar.edu.unlam.mobile2.repository

import retrofit2.http.GET
import retrofit2.http.Query

interface MediaStackApi {
    @GET("v1/news")
    suspend fun getNews(
        @Query("access_key") accessKey: String,
        @Query("languages") language: String,

        ): MediaStackResponse
}


// 5e48b03cc3ee66a83b4478052ef16fb3