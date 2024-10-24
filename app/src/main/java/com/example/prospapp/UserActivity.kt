package com.example.prospapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class UserActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // Inicializando o Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Referência aos campos de texto
        val newPasswordEditText = findViewById<EditText>(R.id.newPasswordEditText)
        val deleteAccountButton = findViewById<Button>(R.id.deleteAccountButton)
        val changePasswordButton = findViewById<Button>(R.id.changePasswordButton)

        // Configuração do botão para alterar a senha
        changePasswordButton.setOnClickListener {
            val newPassword = newPasswordEditText.text.toString().trim()
            if (newPassword.isNotEmpty()) {
                changePassword(newPassword)
            } else {
                Toast.makeText(this, "Por favor, insira uma nova senha!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuração do botão para excluir a conta
        deleteAccountButton.setOnClickListener {
            deleteAccount()
        }
    }

    private fun changePassword(newPassword: String) {
        val user = auth.currentUser
        user?.let {
            user.updatePassword(newPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Erro ao alterar a senha!", Toast.LENGTH_SHORT).show()
                    }
                }
        } ?: run {
            Toast.makeText(this, "Usuário não autenticado!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteAccount() {
        val user = auth.currentUser
        user?.let {
            user.delete()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Conta excluída com sucesso!", Toast.LENGTH_SHORT).show()
                        // Voltar para a tela de login ou inicial
                        finish() // Encerra a UserActivity
                    } else {
                        Toast.makeText(this, "Erro ao excluir a conta!", Toast.LENGTH_SHORT).show()
                    }
                }
        } ?: run {
            Toast.makeText(this, "Usuário não autenticado!", Toast.LENGTH_SHORT).show()
        }
    }
}
