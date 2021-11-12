package com.deny.studyarchietecturemvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deny.studyarchietecturemvvm.R
import com.deny.studyarchietecturemvvm.model.Pessoa
import org.w3c.dom.Text

class PessoaAdapter(var listaPessoa: MutableList<Pessoa> ):
    RecyclerView.Adapter<PessoaAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(itemPessoa: Pessoa){
            var nome: TextView = itemView.findViewById(R.id.textViewListaNome)
            var idade: TextView = itemView.findViewById(R.id.textViewListaIdade)
            var email: TextView = itemView.findViewById(R.id.textViewListaEmail)

            nome.text = itemPessoa.nome
            idade.text = itemPessoa.idade.toString()
            email.text = itemPessoa.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_pessoas, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listaPessoa[position])
    }

    override fun getItemCount(): Int = listaPessoa.size
}