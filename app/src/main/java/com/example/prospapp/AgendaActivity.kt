package com.example.prospapp

import AnaliseActivity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
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
                    // Navega para a HomeActivity
                    startActivity(Intent(this, HomeActivity::class.java))
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

        // Referência ao ImageButton com ID imageButton4
        val imageButton4: ImageButton = findViewById(R.id.imageButton4)

        // Configurando o OnClickListener para o ImageButton
        imageButton4.setOnClickListener {
            // Inicia a com.example.prospapp.UserActivity
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
    }
}
