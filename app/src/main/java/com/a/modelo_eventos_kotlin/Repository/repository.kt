package com.a.modelo_eventos_kotlin.Repository

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.a.modelo_eventos_kotlin.ConsumoAPI.listaRecuperaEventos
import com.a.modelo_eventos_kotlin.ConsumoAPI.loginRecuperaToken
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.a.modelo_eventos_kotlin.modelos.modeloLogin

class repository: LifecycleOwner {

    suspend fun   Login(modeloLogin: modeloLogin):String{
        var    Login = loginRecuperaToken().Logar(modeloLogin)
        return Login
    }
    suspend fun   Lista(TokenRecebidoViaLogin:String): MutableLiveData<ArrayList<modeloListaEventos>> {
            var   Lista = listaRecuperaEventos().Recupera(TokenRecebidoViaLogin)
           return Lista
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}

