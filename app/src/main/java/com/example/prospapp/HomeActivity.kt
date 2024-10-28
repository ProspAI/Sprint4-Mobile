package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.action_home

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    // Home está na tela atual, não faz nada
                    true
                }
                R.id.action_analise -> {
                    val intent = Intent(this, AnaliseActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.action_agenda -> {
                    val intent = Intent(this, AgendaActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                else -> false
            }
        }

        val imageButton3: ImageButton = findViewById(R.id.imageButton3)
        imageButton3.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}
