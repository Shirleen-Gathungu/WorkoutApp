package buildyou.workoutlog.API

import buildyou.workoutlog.models.LoginRequest
import buildyou.workoutlog.models.RegisterRequest
import buildyou.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/login")
    suspend fun loginUser(@Body  loginRequest: LoginRequest): Response <LoginRequest>
}