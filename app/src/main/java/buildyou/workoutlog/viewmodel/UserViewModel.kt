package buildyou.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buildyou.workoutlog.Repository.UserRepository
import buildyou.workoutlog.models.LoginRequest
import buildyou.workoutlog.models.RegisterRequest
import buildyou.workoutlog.models.RegisterResponse


class UserViewModel:ViewModel() {
    val userRepository = UserRepository() // instance of user repository
    var loginResponseLiveData = MutableLiveData<LoginRequest>()
    val loginErrorLiveData = MutableLiveData<String?>() // nullable
    var registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registerErrorLiveData = MutableLiveData<String?>()

    //livedata observes data
    fun loginUser (loginRequest: LoginRequest) {
       viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful) {
                loginResponseLiveData.postValue(response.body())
            }
            else{
                val error = response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }
    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            if (response.isSuccessful) {
                registerResponseLiveData.postValue(response.body())
            }
            else{
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }

}