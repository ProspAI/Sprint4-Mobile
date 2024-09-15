package com.example.prospapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prospapp.api.RetrofitConfig
import com.example.prospapp.model.ClienteResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configurar padding para a visualização
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar o botão de login
        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Chama o método fetchClientes ao iniciar a activity
        fetchClientes()
    }

    private fun fetchClientes() {
        // Usa Dispatchers.IO para operações de rede
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Faz a chamada de rede usando o Retrofit
                val response: Response<List<ClienteResponseDTO>> = RetrofitConfig.clienteApiService.getAllClientes()

                if (response.isSuccessful) {
                    val clientes = response.body()
                    clientes?.forEach {
                        println("Cliente: ${it.nome}, Email: ${it.email}")
                    }
                } else {
                    println("Erro ao buscar clientes: ${response.code()}")
                }
            } catch (e: Exception) {
                // Tratar exceções durante a requisição
                println("Erro ao fazer requisição: ${e.message}")
            }
        }
    }
}
