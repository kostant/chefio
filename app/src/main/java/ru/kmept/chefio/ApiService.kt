import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import ru.kmept.chefio.LoginRequest
import ru.kmept.chefio.LoginResponse

interface ApiService {
    @POST("log/")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>
}