package com.example.chatting_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignupScreen: AppCompatActivity(){

    private lateinit var edtname: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnsignup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.hide()
        mAuth=FirebaseAuth.getInstance()
        edtname=findViewById(R.id.edt_name)
        edtEmail=findViewById(R.id.edit_email)
        edtPassword=findViewById(R.id.edit_password)
        btnsignup=findViewById(R.id.signup)

        btnsignup.setOnClickListener {
            val email=edtEmail.text.toString()
            val password=edtPassword.text.toString()
            signup(email,password)

        }

    }

    private fun signup(email: String, password: String) {

        //logic for creating user
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task->if(task.isSuccessful){
                //code for jumping to home
                val intent= Intent(this@SignupScreen,MainActivity::class.java)
                startActivity(intent)


        }else{
            Toast.makeText(this@SignupScreen,"Some error Occured",Toast.LENGTH_SHORT).show()

        }
        }

    }
}