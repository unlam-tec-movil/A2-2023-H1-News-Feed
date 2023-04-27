package ar.edu.unlam.mobile2.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaStackApi {
    @GET("v1/news")
    fun getNews(
        @Query("access_key") apiKey: String,
        @Query("author") author: String,
        @Query("title") title: String,
        @Query("description") description: String,
        @Query("source") source: String,
        @Query("image") image: String,
        @Query("category") category: String,
        @Query("country") country: String = "ar",
        @Query("published_at") published_at: String
        ): Call<MediaStackResponse>
}


// 5e48b03cc3ee66a83b4478052ef16fb3