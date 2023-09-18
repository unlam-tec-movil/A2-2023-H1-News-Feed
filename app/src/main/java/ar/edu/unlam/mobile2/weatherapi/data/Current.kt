package ar.edu.unlam.mobile2.weatherapi.data


import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("cloudcover")
    val cloudcover: Double,
    @SerializedName("feelslike")
    val feelslike: Double,
    @SerializedName("humidity")
    val humidity: Double,
    @SerializedName("observation_time")
    val observationTime: String,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("temperature")
    val temperature: Double,
    @SerializedName("uv_index")
    val uvIndex: Double,
    @SerializedName("visibility")
    val visibility: Double,
    @SerializedName("weather_code")
    val weatherCode: Double,
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("wind_degree")
    val windDegree: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Double
)