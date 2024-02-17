package com.example.chatting_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginScreen:AppCompatActivity() {

    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnlogin:Button
    private lateinit var btnsignup:Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        supportActionBar?.hide()
        mAuth=FirebaseAuth.getInstance()
        edtEmail=findViewById(R.id.edit_email)
        edtPassword=findViewById(R.id.edit_password)
        btnlogin=findViewById(R.id.login)
        btnsignup=findViewById(R.id.signup)


        btnsignup.setOnClickListener {
            val intent1= Intent(this@LoginScreen,SignupScreen::class.java)
            startActivity(intent1)
        }

        btnlogin.setOnClickListener {
            val email=edtEmail.text.toString()
            val password=edtPassword.text.toString()

            login(email,password)
        }





    }

    private fun login(email: String, password: String) {

        //Logic for loging user

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            task->if(task.isSuccessful){
                //code for logging in user

                val intent=Intent(this@LoginScreen,MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this@LoginScreen,"User does not exist",Toast.LENGTH_SHORT).show()
        }
        }


    }


}