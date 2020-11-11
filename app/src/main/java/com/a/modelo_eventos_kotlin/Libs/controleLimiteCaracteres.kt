package com.a.modelo_eventos_kotlin.Libs

class controleLimiteCaracteres {
    fun executa(texto:String):String{
        var textoFormatado:String=""
        if(texto.length>20){
            textoFormatado= texto.substring(0,20)
            textoFormatado = textoFormatado+"..."
            return textoFormatado
        }
        return texto
    }
}