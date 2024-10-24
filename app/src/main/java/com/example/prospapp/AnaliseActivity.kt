import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prospapp.AgendaActivity
import com.example.prospapp.HomeActivity
import com.example.prospapp.R
import com.example.prospapp.UserActivity
import com.example.prospapp.databinding.ActivityAnaliseBinding

class AnaliseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnaliseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnaliseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuração do BottomNavigationView
        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.action_analise -> {
                    // A tela de análise já está em exibição, portanto, não precisa fazer nada
                    true
                }
                R.id.action_agenda -> {
                    startActivity(Intent(this, AgendaActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Configurando o clique do imageButton8
        binding.imageButton8.setOnClickListener {
            // Inicia a UserActivity
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}
