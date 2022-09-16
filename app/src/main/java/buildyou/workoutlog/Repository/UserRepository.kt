package buildyou.workoutlog.Repository

import buildyou.workoutlog.API.ApiClient
import buildyou.workoutlog.API.ApiInterface
import buildyou.workoutlog.models.LoginRequest
import buildyou.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest:LoginRequest)= withContext(Dispatchers.IO){
        val response=apiClient.loginUser(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest:RegisterRequest)= withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequest)
        return@withContext response
    }
}









































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































