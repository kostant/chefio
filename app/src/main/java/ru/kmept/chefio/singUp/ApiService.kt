package ru.kmept.chefio.singUp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("reg/")
    fun createUser(@Body user: User): Call<ResponseBody>
}