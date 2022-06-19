package buildyou.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import buildyou.workoutlog.databinding.ActivityLoginBinding
import buildyou.workoutlog.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvLogin2.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }

    }
    private fun validateSignUp(){
        val email =binding.etEmailAddress2.text.toString()
        val password = binding.etPasswordOne.text.toString()

        if (email.isBlank()){
            binding.tilEmailAddress2.error = "Email is Required"
        }
        if (password.isBlank()){
            binding.tilPasswordOne.error = "Password is Required"
        }

    }

}