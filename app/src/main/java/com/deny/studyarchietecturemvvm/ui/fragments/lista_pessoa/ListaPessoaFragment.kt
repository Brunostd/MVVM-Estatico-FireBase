package com.deny.studyarchietecturemvvm.ui.fragments.lista_pessoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deny.studyarchietecturemvvm.adapter.PessoaAdapter
import com.deny.studyarchietecturemvvm.databinding.FragmentDashboardBinding

class ListaPessoaFragment : Fragment() {

    private lateinit var listaPessoaViewModel: ListaPessoaViewModel
    private var _binding: FragmentDashboardBinding? = null

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

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerViewListaPessoas.layoutManager = LinearLayoutManager(context)

        listaPessoaViewModel.listaPessoas.observe(viewLifecycleOwner, Observer {
            binding.recyclerViewListaPessoas.adapter = PessoaAdapter(it.getListaPessoas())
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