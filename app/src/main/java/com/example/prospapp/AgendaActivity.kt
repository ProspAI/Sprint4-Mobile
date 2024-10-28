package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AgendaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.action_agenda

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
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
                    // Agenda está na tela atual, não faz nada
                    true
                }
                else -> false
            }
        }

        val imageButton4: ImageButton = findViewById(R.id.imageButton4)
        imageButton4.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}
