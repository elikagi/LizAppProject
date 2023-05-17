package com.example.lizappproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var Edt_Login:TextView
    lateinit var Edt_Attorney:EditText
    lateinit var Edt_EmailAddress:EditText
    lateinit var Edt_Password:EditText
    lateinit var Edt_tvRedirect:TextView
    lateinit var Btn_Login:Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Edt_EmailAddress = findViewById(R.id.Edt_EmailAddress)
        Edt_Attorney = findViewById(R.id.Edt_Attorney)
        Edt_Login = findViewById(R.id.Edt_login)
        Edt_Password = findViewById(R.id.Edt_Password)
        Btn_Login = findViewById(R.id.Btn_Login)
        Edt_tvRedirect = findViewById(R.id.Edt_tvRedirecttologin)
        auth = Firebase.auth

        Edt_tvRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        Btn_Login.setOnClickListener {
            signupuser()

        }
    }
    private fun signupuser(){
        val email=Edt_EmailAddress.text.toString()
        val password=Edt_Password.text.toString()

        if (email.isBlank() ||password.isBlank() ||password.isBlank()){
            Toast.makeText(this,"Please email and password cannot be blank", Toast.LENGTH_LONG).show()
            return
        }else if (password!=password){
            Toast.makeText(this,"Password do not match", Toast.LENGTH_LONG).show()
            return
        }
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this,"Logged In Successfully", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"User Account Failed", Toast.LENGTH_LONG).show()
            }
        }
    }
}