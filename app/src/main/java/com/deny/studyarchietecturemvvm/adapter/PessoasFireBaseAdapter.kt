package com.deny.studyarchietecturemvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deny.studyarchietecturemvvm.R
import com.deny.studyarchietecturemvvm.model.PessoaFireBase

class PessoasFireBaseAdapter(var dataList: MutableList<PessoaFireBase>):
    RecyclerView.Adapter<PessoasFireBaseAdapter.MyViewHolder>() {

    /*private var dataList = mutableListOf<PessoaFireBase>()

    fun setDataList(data: MutableList<PessoaFireBase>){
        dataList = data
    }*/

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(itemPessoa: PessoaFireBase){
            var nome: TextView = itemView.findViewById(R.id.textViewListaNome)
            var idade: TextView = itemView.findViewById(R.id.textViewListaIdade)
            var email: TextView = itemView.findViewById(R.id.textViewListaEmail)

            nome.text = itemPessoa.nome
            idade.text = itemPessoa.idade.toString()
            email.text = itemPessoa.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.lista_pessoas, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}