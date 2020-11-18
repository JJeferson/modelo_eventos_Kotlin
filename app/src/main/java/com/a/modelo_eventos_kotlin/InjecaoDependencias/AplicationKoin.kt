package com.a.modelo_eventos_kotlin.InjecaoDependencias

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AplicationKoin: Application() {

    override fun onCreate(){
    super.onCreate()

        startKoin{
        androidContext(this@AplicationKoin)

        modules(Modulo)
        }




    }
}