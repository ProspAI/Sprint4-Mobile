package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prospapp.databinding.ActivityAnaliseBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AnaliseActivity : AppCompatActivity() {

        private lateinit var binding: ActivityAnaliseBinding
        private lateinit var database: DatabaseReference

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityAnaliseBinding.inflate(layoutInflater)
                setContentView(binding.root)

                // Configurando a referência ao Firebase Database
                database = FirebaseDatabase.getInstance().getReference("Usuarios")

                // Configura a barra de navegação
                val bottomNavigationView = binding.bottomNavigation
                bottomNavigationView.selectedItemId = R.id.action_analise

                // Configura os Spinners
                setupSpinners()

                // Configura o listener para a barra de navegação
                bottomNavigationView.setOnNavigationItemSelectedListener { item ->
                        when (item.itemId) {
                                R.id.action_home -> {
                                        val intent = Intent(this, HomeActivity::class.java)
                                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                                        startActivity(intent)
                                        finish()
                                        true
                                }
                                R.id.action_analise -> true
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

                // Configura o botão "Gerar" para enviar os dados dos Spinners para o Firebase
                binding.button3.setOnClickListener {
                        enviarDadosParaFirebase()
                }

                // Configura o botão para redirecionar para a UserActivity
                binding.imageButton8.setOnClickListener {
                        startActivity(Intent(this, UserActivity::class.java))
                }
        }

        private fun setupSpinners() {
                // Configuração do Spinner de Gênero
                val spinnerGenero: Spinner = binding.spinnerGenero
                ArrayAdapter.createFromResource(
                        this,
                        R.array.genero_array,
                        android.R.layout.simple_spinner_item
                ).also { adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerGenero.adapter = adapter
                }

                // Configuração do Spinner de Faixa Etária
                val spinnerFaixaEtaria: Spinner = binding.spinnerFaixaEtaria
                ArrayAdapter.createFromResource(
                        this,
                        R.array.faixa_etaria_array,
                        android.R.layout.simple_spinner_item
                ).also { adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerFaixaEtaria.adapter = adapter
                }

                // Configuração do Spinner de Localização
                val spinnerLocalizacao: Spinner = binding.spinnerLocalizacao
                ArrayAdapter.createFromResource(
                        this,
                        R.array.localizacao_array,
                        android.R.layout.simple_spinner_item
                ).also { adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerLocalizacao.adapter = adapter
                }

                // Configuração do Spinner de Escolaridade
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

        private fun enviarDadosParaFirebase() {
                // Obtenha os valores selecionados dos Spinners
                val genero = binding.spinnerGenero.selectedItem.toString()
                val faixaEtaria = binding.spinnerFaixaEtaria.selectedItem.toString()
                val localizacao = binding.spinnerLocalizacao.selectedItem.toString()
                val escolaridade = binding.spinnerEscolaridade.selectedItem.toString()

                // Estrutura de dados para salvar os dados
                val dadosUsuario = mapOf(
                        "genero" to genero,
                        "faixaEtaria" to faixaEtaria,
                        "localizacao" to localizacao,
                        "escolaridade" to escolaridade
                )

                // Envie os dados para o Firebase
                database.child("dadosAnalise").push().setValue(dadosUsuario)
                        .addOnSuccessListener {
                                Toast.makeText(this, "Dados enviados com sucesso!", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {
                                Toast.makeText(this, "Erro ao enviar os dados.", Toast.LENGTH_SHORT).show()
                        }
        }
}
