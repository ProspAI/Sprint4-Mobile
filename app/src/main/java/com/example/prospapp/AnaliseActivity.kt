package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AnaliseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analise)

        // Configuração do BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.action_analise -> {
                    // A tela de análise já está em exibição, portanto, não precisa fazer nada
                    true
                }
                R.id.action_agenda -> {
                    startActivity(Intent(this, android.R.drawable.ic_menu_agenda::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
