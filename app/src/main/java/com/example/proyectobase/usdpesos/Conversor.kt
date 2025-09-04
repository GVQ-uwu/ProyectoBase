package com.example.proyectobase.usdpesos

object Conversor {

    /**
     * Formula convertir pesos a usd
     * retorna un double
     */
    fun convertir_usd_double(valorPesos: Int): Double {

        var tipoCambio:Double = 900.0
        var resultado:Double = valorPesos / tipoCambio
        return resultado
    }

    fun convertir_usd_string(valorPesos: Int): String {

        try {
            var tipoCambio: Double = 900.0
            var resultado: Double = valorPesos / tipoCambio
            return resultado.toString()

        }catch (e: ArithmeticException){
            return "0"
        }finally {
            println("error: division en cero")
        }
    }

    fun convertir_usd_int(valorPesos: Int): Int {
        var tipoCambio:Int = 900
        var resultado:Int = valorPesos / tipoCambio
        return resultado
    }
}