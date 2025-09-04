package com.example.proyectobase.funciones

object OpMatematicas {
    fun sumar(valor1: Int, valor2 : Int): Int{
        return valor1 + valor2
    }

    fun restar(valor1: Int, valor2 : Int): Int{
        return valor1 - valor2
    }

    fun multiplicar(valor1: Int, valor2 : Int): Int{
        return valor1 * valor2
    }

    fun dividir(valor1: Int, valor2 : Int): Int {
        try {
            // controlamos el error
            return valor1 / valor2
        }
        catch (e: ArithmeticException){
            return 0
        }
        finally {
            println("SE HA CONTROLANDO LA EXCEPCION")
        }
    }
}