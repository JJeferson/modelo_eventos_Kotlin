package com.a.modelo_eventos_kotlin.ConsumoAPI

import android.os.StrictMode
import okhttp3.OkHttpClient
import okhttp3.Request

class perfilRecuperaDadosPerfil {

    fun executaRest(TokenRecebidoViaLogin: String?): String {

        var policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var client = OkHttpClient().newBuilder()
            .build()

        var recuperaToken = TokenRecebidoViaLogin
        val request: Request = Request.Builder()
            .url("https://selecao.api.homolog.somosdx.co/user")
            .method("GET", null)
            .addHeader(
                "Authorization",
                "Bearer "+recuperaToken
            )
            .build()



        val response = client.newCall(request).execute()
        var resposta  = response.body()!!.string()



        //-------
        return resposta
    }
}