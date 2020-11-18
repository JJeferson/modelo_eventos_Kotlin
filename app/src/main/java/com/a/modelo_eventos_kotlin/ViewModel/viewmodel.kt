package com.a.modelo_eventos_kotlin.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.a.modelo_eventos_kotlin.Repository.repository
import com.a.modelo_eventos_kotlin.modelos.modeloLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewmodel(val repository :repository): ViewModel(), LifecycleOwner  {

    fun  RecuperaPerfil(TokenRecebidoViaLogin:String) :String {

        var    dados:String = repository.RecuperaPerfil(TokenRecebidoViaLogin)
        return dados
    }

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