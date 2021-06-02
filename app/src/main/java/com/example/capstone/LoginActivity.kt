package com.example.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.capstone.data.User
import com.example.capstone.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener {
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()

            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnSuccessListener {
                Toast.makeText(this,"Login sukses", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                }
                    .addOnFailureListener { exception: Exception ->
                        Log.d("Login error", "$exception")
                        Toast.makeText(this,"Login gagal", Toast.LENGTH_SHORT).show()
                    }
        }

        binding.btnLinkToRegisterScreen.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


//        firebaseAuth.signInWithEmailAndPassword()
//        firebaseAuth.createUserWithEmailAndPassword("sasa@gmail.com", "12345").addOnSuccessListener {
//            val uid = firebaseAuth.currentUser?.uid
//            if (uid != null) {
//                firebaseFirestore.collection("Users").document(uid).set(User("adli", "blabla"))
//            }
//        }

//        firebaseFirestore.collection("Users").whereEqualTo()
    }
}