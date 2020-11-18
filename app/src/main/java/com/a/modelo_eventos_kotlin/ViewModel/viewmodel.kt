package com.a.modelo_eventos_kotlin.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.a.modelo_eventos_kotlin.ConsumoAPI.loginRecuperaToken
import com.a.modelo_eventos_kotlin.Repository.repository
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.a.modelo_eventos_kotlin.modelos.modeloLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewmodel(application: Application): AndroidViewModel(application), LifecycleOwner {

    private var repository: repository


    init {
        repository = repository()
    }//fim do init

    fun  RecuperaJson(TokenRecebidoViaLogin:String) :String {

         var    Json:String = repository.RecuperaJson(TokenRecebidoViaLogin)
         return Json
    }



    fun  Login(modeloLogin: modeloLogin):String{
        var     Token:String = ""
        Token = repository.Login(modeloLogin)
        return  Token
    }


    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }

}