package com.deny.studyarchietecturemvvm.model

class GestorPessoas {

    private val listaPessoa: MutableList<Pessoa> = ArrayList<Pessoa>()
    private lateinit var auxPessoa: Pessoa


    fun getListaPessoas(): MutableList<Pessoa> {
        auxPessoa = Pessoa("Bruno", 22, "bruno@teste.com")
        listaPessoa.add(auxPessoa)

        auxPessoa = Pessoa("Breno", 18, "breno@teste.com")
        listaPessoa.add(auxPessoa)

        auxPessoa = Pessoa("Sergio", 33, "sergio@teste.com")
        listaPessoa.add(auxPessoa)

        auxPessoa = Pessoa("Carla", 30, "carla@teste.com")
        listaPessoa.add(auxPessoa)

        auxPessoa = Pessoa("Geisa", 36, "geisa@teste.com")
        listaPessoa.add(auxPessoa)

        return listaPessoa
    }

}