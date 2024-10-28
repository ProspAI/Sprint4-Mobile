package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailEditText = findViewById<EditText>(R.id.registerEmailEditText)
        val passwordEditText = findViewById<EditText>(R.id.registerPasswordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val backButton = findViewById<ImageButton>(R.id.backButton2)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validação da senha
            if (password.length < 6) {
                Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Interrompe a execução se a validação falhar
            }

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, HomeActivity::class.java)) // Inicia a HomeActivity
                            finish() // Fecha a RegisterActivity
                        } else {
                            Toast.makeText(this, "Erro ao cadastrar!", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica do botão de voltar para a tela de login
        backButton.setOnClickListener {
            finish() // Fecha a RegisterActivity e volta para a LoginActivity
        }
    }
}
