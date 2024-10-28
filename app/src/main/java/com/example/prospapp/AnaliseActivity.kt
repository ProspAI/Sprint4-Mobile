package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.prospapp.databinding.ActivityAnaliseBinding

class AnaliseActivity : AppCompatActivity() {

        private lateinit var binding: ActivityAnaliseBinding

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityAnaliseBinding.inflate(layoutInflater)
                setContentView(binding.root)

                // Configurando a barra de navegação
                val bottomNavigationView = binding.bottomNavigation
                bottomNavigationView.selectedItemId = R.id.action_analise

                // Configurando os Spinners
                setupSpinners()

                // Configurando o listener para a barra de navegação
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
                                        // A tela de análise já está em exibição, então nada precisa ser feito
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

                binding.imageButton8.setOnClickListener {
                        startActivity(Intent(this, UserActivity::class.java))
                }
        }

        private fun setupSpinners() {
                val spinnerGenero: Spinner = binding.spinnerGenero
                ArrayAdapter.createFromResource(
                        this,
                        R.array.genero_array,
                        android.R.layout.simple_spinner_item
                ).also { adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerGenero.adapter = adapter
                }

                val spinnerFaixaEtaria: Spinner = binding.spinnerFaixaEtaria
                ArrayAdapter.createFromResource(
                        this,
                        R.array.faixa_etaria_array,
                        android.R.layout.simple_spinner_item
                ).also { adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerFaixaEtaria.adapter = adapter
                }

                val spinnerLocalizacao: Spinner = binding.spinnerLocalizacao
                ArrayAdapter.createFromResource(
                        this,
                        R.array.localizacao_array,
                        android.R.layout.simple_spinner_item
                ).also { adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerLocalizacao.adapter = adapter
                }

                val spinnerEscolaridade: Spinner = binding.spinnerEscolaridade
                ArrayAdapter.createFromResource(
                        this,
                        R.array.escolaridade_array,
                        android.R.layout.simple_spinner_item
                ).also { adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerEscolaridade.adapter = adapter
                }
        }
}
