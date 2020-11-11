package com.a.modelo_eventos_kotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.modelo_eventos_kotlin.Adapter.adapter
import com.a.modelo_eventos_kotlin.ConsumoAPI.listaRecuperaEventos
import com.a.modelo_eventos_kotlin.ConsumoAPI.perfilRecuperaDadosPerfil
import com.a.modelo_eventos_kotlin.Libs.controleLimiteCaracteresPERFILBio
import com.a.modelo_eventos_kotlin.Libs.validaCamposPerfilStringNullOuVazio
import com.a.modelo_eventos_kotlin.R
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_lista_recyclerview_eventos.view.*
import kotlinx.android.synthetic.main.perfil_fragment.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class perfil_Fragment : Fragment() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPreferences = getActivity()?.getSharedPreferences("ArquivoConsulta", AppCompatActivity.MODE_PRIVATE)
        val RecebeToken = sharedPreferences?.getString("Token", "")

        var Nome= view.findViewById<TextView>(R.id.nome)
        var Email= view.findViewById<TextView>(R.id.email)
        var Bio= view.findViewById<TextView>(R.id.bio)
       // var ImageView_foto= view.findViewById<ImageView>(R.id.imageView)
        var CpfEditText= view.findViewById<EditText>(R.id.cpfEditText)
        var Gravar= view.findViewById<Button>(R.id.gravar)


        var dadosComoString = perfilRecuperaDadosPerfil().executaRest(RecebeToken)
        try {

            var jsonObject = JSONObject(dadosComoString)
            var RecebeNome = jsonObject.get("name").toString()
            var RecebeEmail = jsonObject.get("email").toString()
            var RecebeBio = jsonObject.get("description").toString()

            var ValidaNome  = validaCamposPerfilStringNullOuVazio().executa(RecebeNome)
            var ValidaEmail = validaCamposPerfilStringNullOuVazio().executa(RecebeEmail)
            var ValidaBio   = validaCamposPerfilStringNullOuVazio().executa(RecebeBio)
            var formataBio = controleLimiteCaracteresPERFILBio().executa(ValidaBio)
            Nome.setText(ValidaNome)
            Email.setText(ValidaEmail)
            Bio.setText(formataBio)


           // Nome.setText("teste")
           // Email.setText("teste")
           // Bio.setText("teste")


         //   var CaminhoFoto:String = jsonObject.get("photo").toString()
         //   Glide.with(ImageView_foto).load(CaminhoFoto).into(ImageView_foto)

        } catch (e: JSONException) {
            e.printStackTrace()
        }//Final do try



    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.perfil_fragment, container, false)
    }
}