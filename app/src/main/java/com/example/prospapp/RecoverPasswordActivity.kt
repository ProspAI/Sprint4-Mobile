package com.example.prospapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RecoverPasswordActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        // Inicializando o Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Referência aos campos
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val recoverButton = findViewById<Button>(R.id.recoverButton)

        // Configuração do botão de recuperação de senha
        recoverButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            // Verifica se o campo de email não está vazio e contém um '@'
            if (email.isNotEmpty() && email.contains("@")) {
                recoverPassword(email)
            } else {
                Toast.makeText(this, "Por favor, insira um email válido!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun recoverPassword(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Email de recuperação enviado!", Toast.LENGTH_SHORT).show()
                    finish() // Volta para a tela anterior
                } else {
                    Toast.makeText(this, "Erro ao enviar email de recuperação!", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
