package com.example.prospapp

import AgendaActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Define o item "Home" como selecionado ao carregar a tela
        bottomNavigationView.selectedItemId = R.id.action_home

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    // Home está na tela atual, não faz nada
                    true
                }
                R.id.action_analise -> {
                    startActivity(Intent(this, AnaliseActivity::class.java))
                    true
                }
                R.id.action_agenda -> {
                    startActivity(Intent(this, AgendaActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
