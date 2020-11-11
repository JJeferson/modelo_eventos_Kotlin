package com.a.modelo_eventos_kotlin.Libs

class controleLimiteCaracteresPERFILBio {


    fun executa(texto:String):String{
        var textoFormatado:String=""
        if(texto.length>70){
            textoFormatado= texto.substring(0,70)
            textoFormatado = textoFormatado+"..."
            return textoFormatado
        }
        return texto
    }
}