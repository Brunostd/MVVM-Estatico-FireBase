package com.deny.studyarchietecturemvvm.ui.fragments.pessoa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deny.studyarchietecturemvvm.model.Pessoa

class PessoaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    //Gerenciando Pessoa
    var instanciaPessoa: Pessoa = Pessoa(
        nome = "Bruno",
        idade = 22,
        email = "bruno.std"
    )
    private val _pessoa = MutableLiveData<Pessoa>().apply {
        value = instanciaPessoa
    }
    val pessoa: LiveData<Pessoa> = _pessoa
}