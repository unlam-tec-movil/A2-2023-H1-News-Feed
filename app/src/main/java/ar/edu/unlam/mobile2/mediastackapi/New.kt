package ar.edu.unlam.mobile2.mediastackapi

import androidx.compose.runtime.MutableState
import java.io.Serializable

data class New(
    val id: Int?,
    val author: String?,
    val category: String?,
    val country: String?,
    val description: String?,
    val image: String?,
    val language: String?,
    val publishedAt: String?,
    val source: String?,
    val title: String?,
    val url: String?,
    var saved: Boolean = false
):Serializable
