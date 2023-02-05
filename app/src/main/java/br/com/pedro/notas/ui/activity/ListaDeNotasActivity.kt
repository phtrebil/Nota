package br.com.pedro.notas.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.Room
import br.com.pedro.notas.dao.NotaDataBase
import br.com.pedro.notas.databinding.ActivityListaDeNotasBinding
import br.com.pedro.notas.ui.adapter.ListaDeNotasAdapter
import br.com.pedro.notas.ui.adapter.helper.callback.NotaItemTouchHelper


class ListaDeNotasActivity : AppCompatActivity() {

    private val adapter = ListaDeNotasAdapter(this)

    private val binding by lazy {
        ActivityListaDeNotasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
                this,
        NotaDataBase::class.java, "db"
        ).allowMainThreadQueries().build()
        binding.fabAdicionaNota.setOnClickListener {
            val intent = Intent(this, FormularioNotaActivity::class.java)
            startActivity(intent)
        }
        carregaRecyclerView()

    }

    override fun onResume() {
        super.onResume()
        val db = Room.databaseBuilder(
            this,
            NotaDataBase::class.java, "db"
        ).allowMainThreadQueries().build()
        adapter.atualiza(db.notasDao().bustaTudo())

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


    }


}



