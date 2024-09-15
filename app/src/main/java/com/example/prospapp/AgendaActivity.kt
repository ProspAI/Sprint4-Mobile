import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.prospapp.AnaliseActivity
import com.example.prospapp.HomeActivity
import com.example.prospapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AgendaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        // Configurando a BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Definindo listener para tratar cliques nos itens do menu
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            try {
                when (item.itemId) {
                    R.id.action_home -> {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.action_analise -> {
                        val intent = Intent(this, AnaliseActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.action_agenda -> {
                        // Já estamos na AgendaActivity, então não navegue
                        true
                    }
                    else -> false
                }
            } catch (e: Exception) {
                Log.e("AgendaActivity", "Error navigating: ${e.message}")
                false
            }
        }
    }
}
