package com.a.modelo_eventos_kotlin.Adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.a.modelo_eventos_kotlin.Libs.controleLimiteCaracteres
import com.a.modelo_eventos_kotlin.Libs.formataDia_da_Semana
import com.a.modelo_eventos_kotlin.Libs.formataMes_por_Nome
import com.a.modelo_eventos_kotlin.R
import com.a.modelo_eventos_kotlin.modelos.modeloListaEventos
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_lista_recyclerview_eventos.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class adapter(
              var listaEventos: ArrayList<modeloListaEventos> = ArrayList()
              ): RecyclerView.Adapter<adapter.MyViewHolder>()   {


    var recebeLista = listaEventos



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lista_recyclerview_eventos, parent, false))

    }

    fun addList(lista: ArrayList<modeloListaEventos>){

        recebeLista = lista
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return recebeLista.size

    }



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem: modeloListaEventos = recebeLista[position]

        holder.itemView.name.setText(currentItem.name)

        var cidade :String = controleLimiteCaracteres().executa(currentItem.city)
        holder.itemView.city.setText(cidade)

        var nomeDoLocal :String = controleLimiteCaracteres().executa(currentItem.localName)
        holder.itemView.localName.setText(nomeDoLocal)

        var CaminhoFoto:String = currentItem.photo
        Glide.with(holder.itemView.imageViewphoto).load(CaminhoFoto).into(holder.itemView.imageViewphoto)

        var recebeData:String = currentItem.date
        var c: Calendar = Calendar.getInstance()
        c.setTimeInMillis(recebeData.toLong())

        var dia_da_semana =  c.get(Calendar.DAY_OF_WEEK)
        var dia_da_semana_String:String = formataDia_da_Semana().executa(dia_da_semana)
        holder.itemView.dia_semana.setText(dia_da_semana_String)


        var dia:String = SimpleDateFormat("dd").format(c.getTime())
        var ano:String = SimpleDateFormat("yyyy").format(c.getTime())
        var mes:String = SimpleDateFormat("MM").format(c.getTime())

        var mes_Por_NomeString:String = formataMes_por_Nome().executa(mes.toInt())
        holder.itemView.mes.setText(mes_Por_NomeString)
        holder.itemView.dia.setText(dia)


        holder.itemView.layout_Linha.setOnClickListener {view: View ->
            //Evento Onclick Ainda não implementado ainda

        }


        holder.itemView.layout_Linha.setOnLongClickListener{
            // Evento click longo ainda não implementado
            //sendo esse metodo onLongClickListner não posso esquecer desse true boolean no final
            true
        }





    }

}
