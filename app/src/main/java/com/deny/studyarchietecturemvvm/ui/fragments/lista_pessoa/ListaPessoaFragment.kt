package com.deny.studyarchietecturemvvm.ui.fragments.lista_pessoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deny.studyarchietecturemvvm.adapter.PessoasEstaticaAdapter
import com.deny.studyarchietecturemvvm.adapter.PessoasFireBaseAdapter
import com.deny.studyarchietecturemvvm.databinding.FragmentListaPessoasBinding
import com.deny.studyarchietecturemvvm.ui.fragments.pessoa.PessoaViewModel

class ListaPessoaFragment : Fragment() {

    private lateinit var listaPessoaViewModel: ListaPessoaViewModel
    private lateinit var pessoaViewModel: PessoaViewModel
    private var _binding: FragmentListaPessoasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listaPessoaViewModel =
            ViewModelProvider(this).get(ListaPessoaViewModel::class.java)

        pessoaViewModel =
            ViewModelProvider(this).get(PessoaViewModel::class.java)

        _binding = FragmentListaPessoasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        listaPessoaViewModel.listaPessoas.observe(viewLifecycleOwner, Observer {
            binding.recyclerViewListaPessoas.adapter = PessoasEstaticaAdapter(it.getListaPessoas())
            binding.recyclerViewListaPessoas.layoutManager = LinearLayoutManager(context)
        })

        val textViewRecebe: TextView = binding.textViewRecebe
        pessoaViewModel.pessoa.observe(viewLifecycleOwner, Observer {
            var nome: String = "Jaquelini"
            pessoaViewModel.alterarNome(nome)
            textViewRecebe.text = it.nome
        })
        /*val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}