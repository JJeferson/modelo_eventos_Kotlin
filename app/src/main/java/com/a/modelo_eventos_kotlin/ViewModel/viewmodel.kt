package com.a.modelo_eventos_kotlin.ViewModel

import android.app.Application
import androidx.lifecycle.*
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

    fun  Lista(TokenRecebidoViaLogin:String): MutableLiveData<ArrayList<modeloListaEventos>> {
        //lateinit
        var Lista:MutableLiveData<ArrayList<modeloListaEventos>> = MutableLiveData<ArrayList<modeloListaEventos>>()
        viewModelScope.launch(Dispatchers.IO) {
               Lista = repository.Lista(TokenRecebidoViaLogin)
        }
        return Lista
    }



    fun  Login(modeloLogin: modeloLogin):String{
        var Login = ""
        viewModelScope.launch(Dispatchers.IO) {
            Login = repository.Login(modeloLogin)
        }
        return Login
    }


    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }

}