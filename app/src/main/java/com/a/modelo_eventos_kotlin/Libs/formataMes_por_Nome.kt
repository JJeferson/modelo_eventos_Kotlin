package com.a.modelo_eventos_kotlin.Libs

class formataMes_por_Nome {

    fun executa(mes:Int):String{
        val nome_do_Mes = when(mes) {
            1 ->"Jan"
            2 ->"Fev"
            3 ->"Mar"
            4 ->"Abr"
            5 ->"Mai"
            6 ->"Jun"
            7 ->"Jul"
            8 ->"Ago"
            9 ->"Set"
            10 ->"Out"
            11 ->"Nov"
            12 ->"Dez"
            else ->"Mes Invalido"
            }
        return nome_do_Mes
    }
}