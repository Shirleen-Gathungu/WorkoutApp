package buildyou.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import buildyou.workoutlog.R
import buildyou.workoutlog.databinding.ActivityLoginBinding
import buildyou.workoutlog.models.LoginRequest
import buildyou.workoutlog.viewmodel.UserViewModel
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPreps:SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreps=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            validateLogin()
        }


        binding.tvSignUpOne.setOnClickListener {
            val intent= Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse ->
            saveLoginDetails(loginResponse!!)
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            // intent to login user
            startActivity(Intent(baseContext, HomeActivity::class.java))
            finish()
        })
        userViewModel.loginErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun validateLogin(){
        var email=binding.etEmail.text.toString()
        var password=binding.etPasswordOne.text.toString()
        var error=false

        if (email.isBlank()){
            binding.tilEmail.error=getString(R.string.email_required)
            error=true
        }
        if (password.isBlank()){
            binding.tilPassword.error=getString(R.string.password_required)
            error=true
        }
        if (!error){
            var loginRequest=LoginRequest(email,password)
            userViewModel.loginUser(loginRequest)
//            startActivity(Intent(this, HomeActivity::class.java))
//            finish()
        }
    }

    fun saveLoginDetails(loginResponse:LoginResponse){
        val editor=sharedPreps.edit()
        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("PROFILE_ID", loginResponse.profileId)
        editor.apply()
    }

}