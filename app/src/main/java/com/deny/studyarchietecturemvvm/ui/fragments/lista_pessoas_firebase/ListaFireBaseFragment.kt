package com.deny.studyarchietecturemvvm.ui.fragments.lista_pessoas_firebase

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.deny.studyarchietecturemvvm.R
import com.deny.studyarchietecturemvvm.adapter.PessoasFireBaseAdapter
import com.deny.studyarchietecturemvvm.databinding.FragmentFirebaseListaBinding
import com.deny.studyarchietecturemvvm.model.Pessoa
import com.deny.studyarchietecturemvvm.model.PessoaFireBase
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

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

        binding.fab.setOnClickListener(View.OnClickListener {
            addPessoa()
        })
        /*val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    private fun addPessoa(){
        val layout =  LayoutInflater.from(context)
            .inflate(R.layout.dialog_ui, null, false)

        val inputNome = layout.findViewById<EditText>(R.id.editText_input_nome)
        val inputEmail = layout.findViewById<EditText>(R.id.editText_input_email)
        val inputIdade = layout.findViewById<EditText>(R.id.editText_input_idade)

        val alertaDialog = AlertDialog.Builder(context)
        alertaDialog.setView(layout)
        alertaDialog.setNegativeButton("Cancelar", null)
        alertaDialog.setPositiveButton("Salvar" ){ d, i->
            if (!inputNome.text.toString().isEmpty() && !inputEmail.text.toString().isEmpty() && !inputIdade.text.toString().isEmpty()){
                var note: PessoaFireBase = PessoaFireBase(
                    nome     = inputNome.text.toString(),
                    email    = inputEmail.text.toString(),
                    idade    = inputIdade.text.toString()
                )

                FirebaseFirestore.getInstance().collection("pessoas").add(note.toMap())
                Toast.makeText(context, "Pessoa cadastrada com sucesso", Toast.LENGTH_LONG).show()

            } else{
                Toast.makeText(context,
                    "Você deixou de digitar algum campo",
                    Toast.LENGTH_LONG).show()
            }
        }
        alertaDialog.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}