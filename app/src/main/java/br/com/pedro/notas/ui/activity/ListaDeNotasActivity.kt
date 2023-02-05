package br.com.pedro.notas.ui.activity

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.pedro.notas.dao.NotasDao
import br.com.pedro.notas.databinding.ActivityListaDeNotasBinding
import br.com.pedro.notas.model.Notas
import br.com.pedro.notas.ui.adapter.ListaDeNotasAdapter
import br.com.pedro.notas.ui.adapter.helper.callback.NotaItemTouchHelper


class ListaDeNotasActivity : AppCompatActivity() {

    private val dao = NotasDao()
    private val adapter = ListaDeNotasAdapter(this, dao.buscaTudo())
    private val binding by lazy {
        ActivityListaDeNotasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        carregaRecyclerView()




        binding.fabAdicionaNota.setOnClickListener {
            val intent = Intent(this, FormularioNotaActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTudo())
    }

    private fun carregaRecyclerView() {
        val recyclerView = binding.rvNotas
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, 1)
        ItemTouchHelper(NotaItemTouchHelper(adapter)).attachToRecyclerView(recyclerView)

        adapter.quandoClicaNoItem = {
            val intent = Intent(
                this,
                FormularioNotaActivity::class.java
            )
                .apply {
                    putExtra("nota", it)
                }
            startActivity(intent)
        }
        val dadosRecebidos = intent
        if (dadosRecebidos.hasExtra("nota")) {
            val notaRecebida = intent.hasExtra("nota2") as Notas
            val posicaoRecebida = intent.getIntExtra("posicao", -1)

            dao.alteraNota(posicaoRecebida, notaRecebida)
            adapter.altera(posicaoRecebida, notaRecebida)
        }


    }


}
