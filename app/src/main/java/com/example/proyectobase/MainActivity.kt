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

        // Configuramos el evento click para el botón btnLogin
        btnLogin.setOnClickListener {

            // Comparamos el texto ingresado en edUsername y edPasswd con las credenciales base
            if (edUsername.text.toString() == usuarioBase
                && edPasswd.text.toString() == passwBase) {

                // Creamos un objeto Intent para abrir la siguiente actividad (MainActivity2)
                val nuevaVentana = Intent(this, MainActivity2::class.java)

                // Obtenemos el nombre de usuario ingresado para enviarlo a la siguiente actividad
                val ses_username = edUsername.text.toString()

                // Agregamos datos extras al Intent para pasar información entre actividades
                nuevaVentana.putExtra("sesion", ses_username)               // Enviamos el usuario
                nuevaVentana.putExtra("par_contrasena", edPasswd.text.toString()) // Enviamos la contraseña

                // Iniciamos la nueva actividad con el Intent configurado
                startActivity(nuevaVentana)

                // Mostramos un mensaje corto (Toast) de bienvenida al usuario
                val toast = Toast.makeText(this, "Bienvenid@s: $ses_username", Toast.LENGTH_SHORT)
                toast.show()

                // Actualizamos el TextView txMensaje para indicar que el login fue exitoso
                txMensaje.text = "login OK"
            } else {
                // Si las credenciales no coinciden, mostramos mensaje de error en txMensaje
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