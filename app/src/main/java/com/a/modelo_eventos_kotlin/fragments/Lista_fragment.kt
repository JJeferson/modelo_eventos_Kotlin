package com.a.modelo_eventos_kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.modelo_eventos_kotlin.Adapter.adapter
import com.a.modelo_eventos_kotlin.ConsumoAPI.listaRecuperaEventos
import com.a.modelo_eventos_kotlin.ConsumoAPI.loginRecuperaToken
import com.a.modelo_eventos_kotlin.R
import com.a.modelo_eventos_kotlin.Repository.repository
import com.a.modelo_eventos_kotlin.ViewModel.viewmodel
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class Lista_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          var listaEventos = ArrayList<modeloListaEventos>()
          lateinit var adapter:adapter
          lateinit var ListaViewModel: viewmodel
          ListaViewModel = ViewModelProvider(this).get(viewmodel::class.java)


        val sharedPreferences = getActivity()?.getSharedPreferences("ArquivoConsulta", AppCompatActivity.MODE_PRIVATE)
        val RecebeToken = sharedPreferences?.getString("Token", "")

            var recyclerViewBusca= view.findViewById<RecyclerView>(R.id.recyclerView)
            adapter = adapter(listaEventos)
            recyclerViewBusca.setAdapter(adapter)
            recyclerViewBusca.layoutManager = LinearLayoutManager (getActivity())




                getActivity()?.let {
                    if (RecebeToken != null) {
                        ListaViewModel.Lista(RecebeToken).observe(
                            it,
                            Observer<ArrayList<modeloListaEventos>> { it: ArrayList<modeloListaEventos> ->


                                listaEventos.clear()
                                listaEventos.addAll(it)
                                adapter.addList(listaEventos)


                            })

                }

                }




        /*
                getActivity()?.let {
                    if (RecebeToken != null) {
                        listaRecuperaEventos().Recupera(RecebeToken).observe(
                            it,
                            Observer<ArrayList<modeloListaEventos>> { it: ArrayList<modeloListaEventos> ->
                                listaEventos.clear()
                                listaEventos.addAll(it)
                                adapter.addList(listaEventos)

                            })
                    }
                }

        */










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

        return inflater.inflate(R.layout.lista_fragment, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Lista_fragment().apply {
                arguments = Bundle().apply {


                }
            }
    }

}