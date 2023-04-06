package com.example.schmerzfreiapp.data.remote

import com.example.schmerzfreiapp.data.model.ApiResponseData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL_VIMEO: String = "https://api.vimeo.com/"
const val ACCESS_TOKEN = "c5fbf173a4a2b3cd77cd9f3f0fc0e333"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL_VIMEO)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(getOkHttpClient())
        .build()

interface VimeoApiService {
    @GET("users/80963807/videos")
    suspend fun getUserInfo(): Response<ApiResponseData>

}


private fun getOkHttpClient(): OkHttpClient {
    val clientBuilder = OkHttpClient.Builder()
    clientBuilder.addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $ACCESS_TOKEN")
            .build()
        chain.proceed(request)
    }
    return clientBuilder.build()
}

object VimeoApi {
    val retrofitService: VimeoApiService by lazy { retrofit.create(VimeoApiService::class.java) }
}

data class User(
    val name: String?
)







//package com.example.schmerzfreiapp.data.remote
//
//import com.squareup.moshi.Moshi
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//
//// the BASE_URL constant represents the base URL for the API and is used to create the Retrofit instance
//// TODO: implement URL
//const val BASE_URL = "https://somewebsite.com/api/"
//
//// the Moshi object is used to serialize and deserialize JSON data in the API response
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//// the Retrofit object is responsible for creating a service that exposes the methods defined in the ApiService interface
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()
//
//// the interface defines a single method that returns a list of AiApiResponse from the API
//// TODO: define the API response and method
//interface AiApiService {
//    // @GET("keyword")
//    // suspend fun getResponse(...) : ...
//}


//import okhttp3.*
//import org.json.JSONObject
//
//val client = OkHttpClient()
//
//fun main() {
//    val accessToken = "c5fbf173a4a2b3cd77cd9f3f0fc0e333"
//    val url = "https://api.vimeo.com/me/videos"
//
//    val request = Request.Builder()
//        .url(url)
//        .header("Authorization", "Bearer $accessToken")
//        .build()
//
//    client.newCall(request).execute().use { response ->
//        val responseData = response.body?.string()
//        val jsonObject = JSONObject(responseData)
//        println(jsonObject)
//    }
//}
