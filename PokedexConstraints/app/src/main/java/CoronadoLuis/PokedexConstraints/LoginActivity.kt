package CoronadoLuis.PokedexConstraints

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUser = findViewById<EditText>(R.id.etUser)
        val etPass = findViewById<EditText>(R.id.etPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val user = etUser.text.toString()
            val pass = etPass.text.toString()

            // para que no este vacio
            if (user.isNotEmpty() && pass.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                // Opcional: pasamos el nombre del usuario a la siguiente pantalla
                intent.putExtra("TRAINER_NAME", user)
                startActivity(intent)
                finish() // para cerrar el login para que no pueda volver atrás
            } else {
                Toast.makeText(this, "Los campos estan vacios debes de al menos poner un USUARIO y una CONTRASEÑA", Toast.LENGTH_SHORT).show()
            }
        }
    }
}