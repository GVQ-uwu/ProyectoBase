package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//importo el package creado
import com.example.proyectobase.funciones.OpMatematicas

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val numeroUno: EditText = findViewById(R.id.ed_opUno)
        val numeroDos: EditText = findViewById(R.id.ed_opDos)
        val txResultado: TextView = findViewById(R.id.tx_resultado_act4)
        val spOperacionesMat: Spinner = findViewById(R.id.sp_operaciones)
        val btnCalcular: Button = findViewById(R.id.btn_calcular)

        /**
         * Declaramos un array list menu
         */

        val opcionesSpinner = arrayOf(
            "Sumar"
            , "Restar"
            , "Multiplicar"
            , "Hola Mundo"
            , "Dividir")

        //adaptador de Array
        val adaptador = ArrayAdapter(this
            , android.R.layout.simple_list_item_1
            , opcionesSpinner)

        //
        spOperacionesMat.adapter = adaptador

        // leer item de lista seleccionado
        var str_op_selected = spOperacionesMat.selectedItem.toString()


        btnCalcular.setOnClickListener {

            var numeroUnoConv:Int = numeroUno.text.toString().toIntOrNull() ?: 0
            var numeroDosConv:Int = numeroDos.text.toString().toIntOrNull() ?: 0

            if(str_op_selected == "Sumar"){
                val resultado = OpMatematicas.sumar(numeroUnoConv, numeroDosConv)
                txResultado.text = resultado.toString()+" op: " +str_op_selected.toString()

            }else if(str_op_selected == "Restar"){
                val resultado = OpMatematicas.restar(numeroUnoConv, numeroDosConv)
                txResultado.text = resultado.toString()+" op: " +str_op_selected.toString()
            }



        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}