package com.example.quizgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomnavigationActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val quizFragment = QuizFragment()

    private lateinit var activeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomnavigation)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, dashboardFragment, "DashBoard").hide(dashboardFragment)
            add(R.id.fragment_container, quizFragment, "Quiz")
        }.commit()

        activeFragment = dashboardFragment

        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_dashboard -> showFragment(dashboardFragment)
                R.id.navigation_quiz -> showFragment(quizFragment)
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
        activeFragment = fragment
    }
}