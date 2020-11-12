package com.a.modelo_eventos_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.a.modelo_eventos_kotlin.ConsumoAPI.loginRecuperaToken
import com.a.modelo_eventos_kotlin.modelos.modeloLogin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



         buttonLogar.setOnClickListener { view ->
         Logar()
         }


    }//fim do oncreate

    fun Logar (){

        val sharedPreferences = getSharedPreferences("ArquivoConsulta", MODE_PRIVATE)
        val editor = sharedPreferences.edit()



        var recebeEmail = nome.text.toString()
        var recebeSenha = senha.text.toString()

        val EnviaDados = modeloLogin(email=recebeEmail,senha=recebeSenha)
        var testaLogin:String = loginRecuperaToken().Logar(EnviaDados)

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