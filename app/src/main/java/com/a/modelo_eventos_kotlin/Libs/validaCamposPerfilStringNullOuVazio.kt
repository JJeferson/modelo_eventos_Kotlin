package com.a.modelo_eventos_kotlin.Libs

class validaCamposPerfilStringNullOuVazio {

    fun executa(texto:String):String{
        val resposta = when(texto) {
            "" ->"Campo Vazio no Json"
            null ->"Campo veio nulo do Json"
            else ->texto
        }
      return resposta
    }
}