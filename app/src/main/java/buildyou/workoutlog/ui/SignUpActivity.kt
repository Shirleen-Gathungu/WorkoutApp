package buildyou.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import buildyou.workoutlog.databinding.ActivitySignUpBinding
import buildyou.workoutlog.models.RegisterRequest
import buildyou.workoutlog.models.RegisterResponse
import buildyou.workoutlog.API.ApiClient
import buildyou.workoutlog.API.ApiInterface
import buildyou.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            validateSignup()
        }
        binding.tvLogin2.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer{ registerResponse ->
            Toast.makeText(baseContext,registerResponse?.message,Toast.LENGTH_LONG).show()
            // intent to login
            startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
        })
        userViewModel.loginErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }

    fun validateSignup() {
        var firstname = binding.etFirstName.text.toString()
        var lastname = binding.etLastName.text.toString()
        var email = binding.etEmailAddress2.text.toString()
        var phonenumber = binding.etPhoneNumber.text.toString()
        var password = binding.etPasswordOne.text.toString()
        var confirm_password = binding.etConfirmPassword.text.toString()

        var error = false
        if (firstname.isBlank()) {
            error = true
            binding.tilFirstName.error = "First name is required"
        }
        if (lastname.isBlank()) {
            error = true
            binding.tilLastName.error = "Last name is required"
        }
        if (email.isBlank()) {
            error = true
            binding.tilEmailAddress2.error = "Email is required"
        }
        if (phonenumber.isBlank()) {
            error = true
            binding.tilPhoneNumber.error
        }
        if (password.isBlank()) {
            error = true
            binding.tilPasswordOne.error = "Password is required"
        }
        if (confirm_password.isBlank()) {
            error = true
            binding.tilConfirmPassword.error = "confirm password required"
        }
        if (password != confirm_password) {
            error = true
            binding.tilConfirmPassword.error = "Wrong password"
        }
        if (!error){
            var registerRequest = RegisterRequest(firstname,lastname,email,phonenumber,password)
            userViewModel.loginUser(registerRequest)
        }
    }
}
