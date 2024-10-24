package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializando o Firebase Auth
        auth = FirebaseAuth.getInstance()

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

            // Verificando se os campos estão preenchidos
            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuração do botão de voltar para a tela inicial
        backButton.setOnClickListener {
            finish() // Fecha a atividade atual e volta para a anterior
        }
    }

    private fun loginUser(email: String, password: String) {
        // Autenticar usuário com Firebase
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login bem-sucedido, navegue para a HomeActivity
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // Finaliza a LoginActivity
                } else {
                    // Se o login falhar, mostre uma mensagem ao usuário
                    Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
