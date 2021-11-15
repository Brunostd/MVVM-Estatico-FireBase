package com.deny.studyarchietecturemvvm.ui.fragments.lista_pessoas_firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deny.studyarchietecturemvvm.adapter.PessoasFireBaseAdapter
import com.deny.studyarchietecturemvvm.databinding.FragmentFirebaseListaBinding

class ListaFireBaseFragment : Fragment() {

    private lateinit var listaFireBaseViewModel: ListaFireBaseViewModel
    private var _binding: FragmentFirebaseListaBinding? = null
    private lateinit var adapter: PessoasFireBaseAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listaFireBaseViewModel =
            ViewModelProvider(this).get(ListaFireBaseViewModel::class.java)

        _binding = FragmentFirebaseListaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        listaFireBaseViewModel.getLista().observe(viewLifecycleOwner, Observer {
            adapter = PessoasFireBaseAdapter(it)
            binding.recyclerViewFireBase.adapter = adapter
            binding.recyclerViewFireBase.layoutManager = LinearLayoutManager(context)
            adapter.notifyDataSetChanged()
        })

        /*val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}