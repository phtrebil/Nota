package br.com.pedro.notas.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.pedro.notas.Dao.NotasDao
import br.com.pedro.notas.R
import br.com.pedro.notas.databinding.ActivityListaDeNotasBinding
import br.com.pedro.notas.ui.adapter.ListaDeNotasAdapter

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

    private fun carregaRecyclerView() {
        val recyclerView = binding.rvNotas
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, 1)
    }
}