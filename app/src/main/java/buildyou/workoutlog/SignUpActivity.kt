package buildyou.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
     lateinit var tilFirstName: TextInputLayout
     lateinit var etFirstName: EditText
     lateinit var tilLastName: TextInputLayout
     lateinit var etLastName: EditText
     lateinit var tilPasswordOne: TextInputLayout
     lateinit var etPasswordOne: EditText
     lateinit var tilConfirmPassword: TextInputLayout
     lateinit var etConfirmPassword: EditText
    lateinit var tilEmailAddress2: TextInputLayout
    lateinit var etEmailAddress2: EditText
    lateinit var btnSignUp: Button
    lateinit var tvLogin2 : TextView
    lateinit var imgFirst : ImageView
   lateinit var imgLastName : ImageView
     lateinit var imgEmailAddress : ImageView
     lateinit var imgLock : ImageView
     lateinit var imgLock2 : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tvLogin2=findViewById(R.id.tvLogin2)
        btnSignUp =findViewById(R.id.btnSignUp)
        tilEmailAddress2=findViewById(R.id.tilEmailAddress2)
        tilPasswordOne =findViewById(R.id.tilPasswordOne)
        etEmailAddress2 =findViewById(R.id.etEmailAddress2)
        etPasswordOne =findViewById(R.id.etPasswordOne)
        tilFirstName =findViewById(R.id.tilFirstName)
        tilLastName =findViewById(R.id.tilLastName)
        etFirstName =findViewById(R.id.etFirstName)
        etLastName =findViewById(R.id.etLastName)
        tilConfirmPassword =findViewById(R.id.tilConfirmPassword)
        etConfirmPassword =findViewById(R.id.etConfirmPassword)
        imgFirst =findViewById(R.id.imgFirst)
        imgLastName =findViewById(R.id.imgLastName)
        imgEmailAddress =findViewById(R.id.imgEmailAddress)
        imgLock =findViewById(R.id.imgLock)
        imgLock2 =findViewById(R.id.imgLock2)

        tvLogin2.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener {
            validateSignUp()
        }

    }
    private fun validateSignUp(){
        val email =etEmailAddress2.text.toString()
        val password = etPasswordOne.text.toString()

        if (email.isBlank()){
            tilEmailAddress2.error = "Email is Required"
        }
        if (password.isBlank()){
            tilPasswordOne.error = "Password is Required"
        }

    }

}