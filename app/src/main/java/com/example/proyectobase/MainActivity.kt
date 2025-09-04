package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //inicializamos variables de elementos layout
        val edUsername:EditText = findViewById(R.id.ed_username)
        val edPasswd:EditText = findViewById(R.id.ed_password)
        val btnLogin:Button = findViewById(R.id.btn_login)
        val txMensaje:TextView = findViewById(R.id.tx_mensaje)

        // variables para comparar password
        var usuarioBase = "ch.munozs"
        var passwBase = "admin123"

        btnLogin.setOnClickListener {

            if(edUsername.text.toString() == usuarioBase
                && edPasswd.text.toString() == passwBase){

                // creo un objeto intent
                val nuevaVentana = Intent(this, MainActivity2::class.java)
                /**
                 * creo una variable, llamo al metodo putExtra(nombre_put, valor_variable)
                 *
                 */

                var ses_username = edUsername.text.toString()

                nuevaVentana.putExtra("sesion",ses_username )
                nuevaVentana.putExtra("par_contrasena", edPasswd.text.toString() )                //abrimos el activity
                startActivity(nuevaVentana)

                val toast = Toast.makeText(this, "Bienvenid@s: "+ses_username, Toast.LENGTH_SHORT) // in Activity
                toast.show()
                txMensaje.text = "login OK"
            }else{
                txMensaje.text = "login NO"
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}