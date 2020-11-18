package com.a.modelo_eventos_kotlin.InjecaoDependencias

import android.app.Application
import com.a.modelo_eventos_kotlin.Repository.repository
import com.a.modelo_eventos_kotlin.ViewModel.viewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Modulo = module{


    single { repository() }



    viewModel {
         viewmodel (
             repository= get()
             )
     }


}