package com.deny.studyarchietecturemvvm.ui.fragments.lista_pessoa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deny.studyarchietecturemvvm.model.GestorPessoas
import com.deny.studyarchietecturemvvm.model.Pessoa

class ListaPessoaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    //Gerenciando Lista Pessoas
    var intanciaListaPessoa: GestorPessoas = GestorPessoas()

    private val _listaPessoas = MutableLiveData<GestorPessoas>().apply {
        value = intanciaListaPessoa
    }
    val listaPessoas: LiveData<GestorPessoas> = _listaPessoas
}