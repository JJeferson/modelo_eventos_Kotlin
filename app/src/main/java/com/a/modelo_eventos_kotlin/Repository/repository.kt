package com.a.modelo_eventos_kotlin.Repository

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.a.modelo_eventos_kotlin.ConsumoAPI.listaRecuperaEventos
import com.a.modelo_eventos_kotlin.ConsumoAPI.loginRecuperaToken
import com.a.modelo_eventos_kotlin.ConsumoAPI.perfilRecuperaDadosPerfil
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.a.modelo_eventos_kotlin.modelos.modeloLogin

class repository: LifecycleOwner {

    fun   RecuperaPerfil(TokenRecebidoViaLogin:String):String{
        var    dados = perfilRecuperaDadosPerfil().executaRest(TokenRecebidoViaLogin)
        return dados
    }


    fun   RecuperaJson(TokenRecebidoViaLogin:String):String{
         var    Json =listaRecuperaEventos().RecuperaJson(TokenRecebidoViaLogin)
         return Json
    }

    fun   Login(modeloLogin: modeloLogin):String {
      var    Token = loginRecuperaToken().Logar(modeloLogin)
      return Token
    }


    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}

