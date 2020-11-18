package com.a.modelo_eventos_kotlin.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.Transition
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.a.modelo_eventos_kotlin.ConsumoAPI.perfilRecuperaDadosPerfil
import com.a.modelo_eventos_kotlin.Libs.controleLimiteCaracteresPERFILBio
import com.a.modelo_eventos_kotlin.Libs.validaCamposPerfilStringNullOuVazio
import com.a.modelo_eventos_kotlin.R
import com.a.modelo_eventos_kotlin.ViewModel.viewmodel
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.target.SimpleTarget
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject

import org.koin.androidx.viewmodel.ext.android.viewModel

class perfil_Fragment : Fragment() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPreferences = getActivity()?.getSharedPreferences("ArquivoConsulta", AppCompatActivity.MODE_PRIVATE)
        val RecebeToken = sharedPreferences?.getString("Token", "")

        var Nome= view.findViewById<TextView>(R.id.nome)
        var Email= view.findViewById<TextView>(R.id.email)
        var Bio= view.findViewById<TextView>(R.id.bio)
        var CpfEditText= view.findViewById<EditText>(R.id.cpfEditText)
        var Gravar= view.findViewById<Button>(R.id.gravar)




        CoroutineScope(Dispatchers.Main).launch {

            val PerfilViewModel: viewmodel by viewModel()
            var dadosComoString = RecebeToken?.let { PerfilViewModel.RecuperaPerfil(it) }
            try {

                var jsonObject = JSONObject(dadosComoString)
                var RecebeNome = jsonObject.get("name").toString()
                var RecebeEmail = jsonObject.get("email").toString()
                var RecebeBio = jsonObject.get("description").toString()

                var ValidaNome = validaCamposPerfilStringNullOuVazio().executa(RecebeNome)
                var ValidaEmail = validaCamposPerfilStringNullOuVazio().executa(RecebeEmail)
                var ValidaBio = validaCamposPerfilStringNullOuVazio().executa(RecebeBio)
                var formataBio = controleLimiteCaracteresPERFILBio().executa(ValidaBio)
                Nome.setText(ValidaNome)
                Email.setText(ValidaEmail)
                Bio.setText(formataBio)


            } catch (e: JSONException) {
                e.printStackTrace()
            }//Final do try

        }

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

