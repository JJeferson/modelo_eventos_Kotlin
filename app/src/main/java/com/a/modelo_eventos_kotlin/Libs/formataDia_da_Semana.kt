package com.a.modelo_eventos_kotlin.Libs

class formataDia_da_Semana {

    fun executa(dia:Int):String{
        val dia_da_Semana = when(dia) {
            1 ->"Dom"
            2 ->"Seg"
            3 ->"Ter"
            4 ->"Quar"
            5 ->"Quin"
            6 ->"Sex"
            7 ->"Sab"
            else ->"Dia Invaido"
        }
        return dia_da_Semana
    }

}