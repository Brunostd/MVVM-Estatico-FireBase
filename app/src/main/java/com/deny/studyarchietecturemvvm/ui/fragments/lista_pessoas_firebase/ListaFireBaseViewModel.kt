package com.deny.studyarchietecturemvvm.ui.fragments.lista_pessoas_firebase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deny.studyarchietecturemvvm.model.GestorPessoasFireBase
import com.deny.studyarchietecturemvvm.model.PessoaFireBase

class ListaFireBaseViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    private var gestorPessoasFireBase: GestorPessoasFireBase = GestorPessoasFireBase()
    fun getLista(): LiveData<MutableList<PessoaFireBase>>{
        val mutableData = MutableLiveData<MutableList<PessoaFireBase>>()
        gestorPessoasFireBase.getUserData().observeForever{
            mutableData.value = it
        }
        return mutableData
    }
}