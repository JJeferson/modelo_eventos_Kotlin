package com.a.modelo_eventos_kotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.modelo_eventos_kotlin.Adapter.adapter
import com.a.modelo_eventos_kotlin.ConsumoAPI.listaRecuperaEventos
import com.a.modelo_eventos_kotlin.R
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import kotlinx.android.synthetic.main.perfil_fragment.*



class perfil_Fragment : Fragment() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


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