package com.example.quizgame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        auth = FirebaseAuth.getInstance()
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val logoutButton = findViewById<ImageView>(R.id.logout)
        logoutButton.setOnClickListener{
            auth.signOut()

            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val gk1 = findViewById<LinearLayout>(R.id.gk)
        gk1.setOnClickListener{
            val intent = Intent(this, GKquizActivity::class.java)
            startActivity(intent)
        }
    }
}