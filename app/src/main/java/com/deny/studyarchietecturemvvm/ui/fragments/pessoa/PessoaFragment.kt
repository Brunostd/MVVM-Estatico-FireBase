package com.deny.studyarchietecturemvvm.ui.fragments.pessoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.deny.studyarchietecturemvvm.databinding.FragmentPessoaBinding

class PessoaFragment : Fragment() {

    private lateinit var pessoaViewModel: PessoaViewModel
    private var _binding: FragmentPessoaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pessoaViewModel =
            ViewModelProvider(this).get(PessoaViewModel::class.java)

        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textHome
        pessoaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        val textViewNome: TextView = binding.textViewNome
        val textViewIdade: TextView = binding.textViewIdade
        val textViewEmail: TextView = binding.textViewEmail
        pessoaViewModel.pessoa.observe(viewLifecycleOwner, Observer {
            textViewNome.text = it.nome
            textViewIdade.text = it.idade.toString()
            textViewEmail.text = it.email
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}