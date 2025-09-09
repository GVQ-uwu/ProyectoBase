package com.example.proyectobase.funciones

object OpMatematicas {
    // Función para sumar dos enteros y devolver el resultado
    fun sumar(valor1: Int, valor2: Int): Int {
        return valor1 + valor2
    }

    // Función para restar el segundo entero al primero y devolver el resultado
    fun restar(valor1: Int, valor2: Int): Int {
        return valor1 - valor2
    }

    // Función para multiplicar dos enteros y devolver el resultado
    fun multiplicar(valor1: Int, valor2: Int): Int {
        return valor1 * valor2
    }

    // Función para dividir el primer entero entre el segundo
    // Incluye manejo de excepción para evitar división por cero
    fun dividir(valor1: Int, valor2: Int): Int {
        try {
            // Intentamos realizar la división
            return valor1 / valor2
        } catch (e: ArithmeticException) {
            // Si ocurre división por cero, devolvemos 0 para evitar error
            return 0
        } finally {
            // Este bloque siempre se ejecuta, aquí imprime mensaje para depuración
            println("SE HA CONTROLADO LA EXCEPCION")
        }
    }
}

