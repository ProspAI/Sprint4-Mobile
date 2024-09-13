package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Referência aos campos de email e senha
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Referência ao botão de voltar
        val backButton = findViewById<ImageButton>(R.id.backButton)

        // Lógica de clique do botão de login
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Verificação simples de email e senha
            if (email == "teste@gmail.com" && password == "123456") {
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()

                // Navegar para a HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

                // Finaliza a LoginActivity para que o usuário não possa voltar para ela ao pressionar o botão "Voltar"
                finish()
            } else {
                Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuração do botão de voltar para a tela inicial
        backButton.setOnClickListener {
            finish() // Fecha a atividade atual e volta para a anterior
        }
    }
}
