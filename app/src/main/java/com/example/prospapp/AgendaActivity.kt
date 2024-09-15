package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prospapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AgendaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        // Configurando a BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Marcar "Agenda" como selecionado
        bottomNavigationView.selectedItemId = R.id.action_agenda

        // Definindo listener para tratar cliques nos itens do menu
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    // Navega para a MainActivity
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.action_analise -> {
                    // Navega para a AnaliseActivity
                    startActivity(Intent(this, AnaliseActivity::class.java))
                    true
                }
                R.id.action_agenda -> {
                    // Já está na AgendaActivity
                    true
                }
                else -> false
            }
        }
    }
}
