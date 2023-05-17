package com.example.lizappproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    lateinit var Edt_Register:TextView
    lateinit var Edt_Name:EditText
    lateinit var Edt_EmailAddress1:EditText
    lateinit var Edt_Password1:EditText
    lateinit var Edt_conPassword:EditText
    lateinit var Edt_Attorney1:EditText
    lateinit var Edt_Date:EditText
    lateinit var Btn_SignUp:Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Edt_Register = findViewById(R.id.Edt_Register)
        Edt_Name = findViewById(R.id.Edt_Name)
        Edt_EmailAddress1 = findViewById(R.id.Edt_EmailAddress1)
        Edt_Password1 = findViewById(R.id.Edt_Password1)
        Edt_conPassword = findViewById(R.id.Edt_conPassword)
        Edt_Attorney1 = findViewById(R.id.Edt_Attorney1)
        Edt_Date = findViewById(R.id.Edt_Date)
        Btn_SignUp = findViewById(R.id.Btn_SignUp)
        auth= Firebase.auth


        Btn_SignUp.setOnClickListener {
            signupuser()

        }
    }
    private fun signupuser(){
        val email=Edt_EmailAddress1.text.toString()
        val password=Edt_Password1.text.toString()
        val conpassword=Edt_conPassword.text.toString()

        if (email.isBlank() ||password.isBlank() ||conpassword.isBlank()){
            Toast.makeText(this,"Registered Successfully ", Toast.LENGTH_LONG).show()
            return
        }else if (password!=password){
            Toast.makeText(this,"This Space Must be Filled", Toast.LENGTH_LONG).show()
            return
        }
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this,"Signed Successfully", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed to create Account", Toast.LENGTH_LONG).show()
            }
        }
    }
}