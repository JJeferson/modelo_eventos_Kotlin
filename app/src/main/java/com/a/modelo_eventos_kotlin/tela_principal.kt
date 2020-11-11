package com.a.modelo_eventos_kotlin

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a.modelo_eventos_kotlin.fragments.Lista_fragment
import com.a.modelo_eventos_kotlin.fragments.perfil_Fragment
import kotlinx.android.synthetic.main.tela_principal.*

class tela_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_principal)

        iniciaLista_Fragment()

        buttonEventos.setOnClickListener { view ->

                iniciaLista_Fragment()

        }


        buttonPerfil.setOnClickListener { view ->
            iniciaPerfil_Fragment()
        }
    }

    fun iniciaLista_Fragment(){
        var fragment = Lista_fragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        efeitoEventos.setBackgroundColor(Color.GREEN)
        efeitoPerfil.setBackgroundColor(Color.parseColor("#1f2212"))


    }
    fun iniciaPerfil_Fragment(){

        var fragment = perfil_Fragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, fragment)
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        efeitoPerfil.setBackgroundColor(Color.GREEN)
        efeitoEventos.setBackgroundColor(Color.parseColor("#1f2212"))
    }
}