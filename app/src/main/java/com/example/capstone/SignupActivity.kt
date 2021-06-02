package com.example.capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.capstone.data.User
import com.example.capstone.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRegistrarse.setOnClickListener {
            val email = binding.registerEmail.text.toString()
            val password = binding.registerPassword.text.toString()
            val name = binding.registerName.text.toString()

            firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener{
                    val uid = firebaseAuth.currentUser?.uid
                    if (uid != null) {
                        firebaseFirestore.collection("Users").document(uid).set(User(name, "Scifi"))
                            .addOnSuccessListener {
                                Log.d("error note", "false")
                            }
                            .addOnFailureListener { exception -> exception
                            Log.d("error note", "$exception")
                            }
                        Log.d("Register", "sukses")
                        Toast.makeText(this,"Register sukses",Toast.LENGTH_SHORT).show()
                    }
            }
                .addOnFailureListener{
                    Toast.makeText(this,"Register gagal",Toast.LENGTH_SHORT).show()
                }
        }
    }
}