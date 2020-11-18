package com.a.modelo_eventos_kotlin.ConsumoAPI

import android.os.StrictMode
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.a.modelo_eventos_kotlin.modelos.modeloLogin
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody


class loginRecuperaToken() {

    fun Logar(modeloLogin: modeloLogin): String{
       // var TokenRecebido = MutableLiveData<String>()
        var Token:String = ""

        var policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val recebeDados = modeloLogin

        var mediaType: MediaType? = MediaType.parse("application/json")
        var formBody = RequestBody.create(
            mediaType,
            "{\r\n  \"email\": \""+recebeDados.email.toString()+"\",\r\n  \"password\": \""+recebeDados.senha.toString()+"\"\r\n}"
        )

        var client = OkHttpClient().newBuilder()
            .build()


        var request: Request = Request.Builder()
            .url("https://selecao.api.homolog.somosdx.co/user/login/")
            .method("POST",formBody)
            .addHeader("Content-Type", "application/json")
            .build()


        val response = client.newCall(request).execute()
        Token  =response.body()!!.string()

        if (Token.indexOf("Bearer") >= 0){
            //formatando o token string
            var ajuste: String = Token.replace("authToken", "")
            var ajuste2: String = ajuste.replace("\"", "")
            var ajuste3: String = ajuste2.replace("{", "")
            var ajuste4: String = ajuste3.replace("}", "")
            var ajuste5: String = ajuste4.replace("Bearer", "")
            var ajuste6: String = ajuste5.replace(":", "")
            var ajuste7: String = ajuste6.replace(" ", "")
            Token = ajuste7
           // TokenRecebido.postValue(Token)
        }else{
          Token = "ERRO AO LOGAR"
        }


        //-------
        return Token

    }

}