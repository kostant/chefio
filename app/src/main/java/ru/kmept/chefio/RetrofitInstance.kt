import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://pargevdotnet.ru/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    fun <T> responseBodyConverter(clazz: Class<T>): Converter<ResponseBody, T> {
        return retrofit.responseBodyConverter(clazz, arrayOfNulls<Annotation>(0))
    }
}