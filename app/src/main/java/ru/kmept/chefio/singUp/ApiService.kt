package ru.kmept.chefio.singUp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import ru.kmept.chefio.RecipeResponse
import ru.kmept.chefio.ZaprosRecipe

interface ApiService {
    @POST("reg/")
    fun createUser(@Body user: User): Call<ResponseBody>

    @POST("recipe/")
    fun GetRecipe(@Body recipe: ZaprosRecipe): Call<RecipeResponse>
}