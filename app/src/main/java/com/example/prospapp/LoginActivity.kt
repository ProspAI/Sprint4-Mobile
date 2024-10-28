package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
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

        // Referências aos campos de email e senha
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Referência ao botão "Cadastre-se"
        val registerButton = findViewById<Button>(R.id.loginButton2)

        // Referência ao botão de voltar
        val backButton = findViewById<ImageButton>(R.id.backButton)

        // Referência ao texto "Esqueceu a senha?"
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotPasswordTextView)

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

        // Configuração do botão de "Cadastre-se" para redirecionar à tela de cadastro
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Configuração do botão de voltar para a tela inicial
        backButton.setOnClickListener {
            finish() // Fecha a atividade atual e volta para a anterior
        }

        // Configuração do texto "Esqueceu a senha?"
        forgotPasswordTextView.setOnClickListener {
            // Inicia a tela de recuperação de senha
            startActivity(Intent(this, RecoverPasswordActivity::class.java))
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
