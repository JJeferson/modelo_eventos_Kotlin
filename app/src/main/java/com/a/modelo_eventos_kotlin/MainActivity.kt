package com.a.modelo_eventos_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.ViewModelProvider
import com.a.modelo_eventos_kotlin.ConsumoAPI.loginRecuperaToken
import com.a.modelo_eventos_kotlin.ViewModel.viewmodel
import com.a.modelo_eventos_kotlin.modelos.modeloLogin
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var LoginViewModel: viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          nome.setText("teste@gmail.com")
          senha.setText("123")
         buttonLogar.setOnClickListener { view ->
         Logar()
         }


    }//fim do oncreate

    fun Logar (){

        val sharedPreferences = getSharedPreferences("ArquivoConsulta", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        LoginViewModel = ViewModelProvider(this).get(viewmodel::class.java)



        var recebeEmail = nome.text.toString()
        var recebeSenha = senha.text.toString()

        val EnviaDados = modeloLogin(email=recebeEmail,senha=recebeSenha)
        var testaLogin: String =""
        //testaLogin = loginRecuperaToken().Logar(EnviaDados)


        testaLogin =  LoginViewModel.Login(EnviaDados)



        if(testaLogin.equals("ERRO AO LOGAR")){
            Toast.makeText(applicationContext,"Resposta do servidor:"+testaLogin,Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext,"Login em andamento",Toast.LENGTH_SHORT).show()

            editor.putString("Token", testaLogin)
            editor.commit()

            acessaTela()
        }

    }

    fun acessaTela(){
        val intent = Intent(this,tela_principal::class.java)
        startActivity(intent)

    }

}//fim da classe