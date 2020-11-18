package com.a.modelo_eventos_kotlin.ConsumoAPI

import android.content.SharedPreferences
import android.os.Build
import android.os.StrictMode
import android.preference.PreferenceManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.a.modelo_eventos_kotlin.modelos.modeloLogin
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class listaRecuperaEventos {


    fun FormataJsonLista(Json:String): MutableLiveData<ArrayList<modeloListaEventos>> {


        var data = Json
        var LiveData = MutableLiveData<ArrayList<modeloListaEventos>>()
        var listaEventos = ArrayList<modeloListaEventos>()
        listaEventos.clear()


                try {

                    var jsonArray = JSONArray(data)
                    var contador: Int = 0
                    var tamanhoLista = jsonArray.length()
                    while (contador <= tamanhoLista) {

                        var jsonObject = jsonArray.getJSONObject(contador)

                        contador = contador + 1

                        var recebeName        = jsonObject.get("name").toString()
                        var recebePhoto       = jsonObject.get("photo").toString()
                        var recebeDescription = jsonObject.get("description").toString()
                        var recebeDate        = jsonObject.get("date").toString()
                        var recebeLocalName   = jsonObject.get("localName").toString()
                        var recebeCity        = jsonObject.get("city").toString()

                        var modeloListaEventos = modeloListaEventos(name=recebeName,
                            photo=recebePhoto,
                            description=recebeDescription,
                            date=recebeDate,
                            localName=recebeLocalName,
                            city=recebeCity)


                        listaEventos.add(modeloListaEventos)
                        LiveData.postValue(listaEventos)
                    }

                    //-----------------------

                } catch (e: JSONException) {
                    e.printStackTrace()
                }//Final do try




        return LiveData
    }

    
    fun RecuperaJson(TokenRecebidoViaLogin:String): String {

        var policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var client = OkHttpClient().newBuilder()
            .build()

        var recuperaToken = TokenRecebidoViaLogin
        val request: Request = Request.Builder()
            .url("https://selecao.api.homolog.somosdx.co/events")
            .method("GET", null)
            .addHeader(
                "Authorization",
                "Bearer "+recuperaToken
            )
            .build()


        val response = client.newCall(request).execute()
        var Json = response.body()!!.string()


        return Json
    }

}