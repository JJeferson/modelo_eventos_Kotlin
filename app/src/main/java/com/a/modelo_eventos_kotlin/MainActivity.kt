package com.a.modelo_eventos_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import com.a.modelo_eventos_kotlin.ConsumoAPI.loginRecuperaToken
import com.a.modelo_eventos_kotlin.ViewModel.viewmodel
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.a.modelo_eventos_kotlin.modelos.modeloLogin
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val LoginViewModel: viewmodel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          nome.setText("teste@gmail.com")
          senha.setText("123")
         buttonLogar.setOnClickListener { view ->
             CoroutineScope(Dispatchers.Main).launch {
             Logar()
             }
         }


    }//fim do oncreate

    fun Logar (){

        val sharedPreferences = getSharedPreferences("ArquivoConsulta", MODE_PRIVATE)
        val editor = sharedPreferences.edit()



        var recebeEmail = nome.text.toString()
        var recebeSenha = senha.text.toString()

        val EnviaDados = modeloLogin(email=recebeEmail,senha=recebeSenha)
        var testaLogin: String =""
        testaLogin = LoginViewModel.Login(EnviaDados)


        when (testaLogin) {
            "ERRO AO LOGAR" -> Toast.makeText(applicationContext,"Resposta do servidor:"+testaLogin,Toast.LENGTH_SHORT).show()
            "" -> Toast.makeText(applicationContext,"Resposta vazia",Toast.LENGTH_SHORT).show()
            null -> Toast.makeText(applicationContext,"Resposta do servidor: NULL",Toast.LENGTH_SHORT).show()  // Duas condições combinadas
            else -> {
                Toast.makeText(applicationContext,"Login em andamento",Toast.LENGTH_SHORT).show()

                editor.putString("Token", testaLogin.toString())
                editor.commit()

                acessaTela()
            }
        }
    }

    fun acessaTela(){
        val intent = Intent(this,tela_principal::class.java)
        startActivity(intent)

    }

}//fim da classe