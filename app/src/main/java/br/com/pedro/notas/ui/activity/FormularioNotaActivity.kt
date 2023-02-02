package br.com.pedro.notas.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.pedro.notas.Dao.NotasDao
import br.com.pedro.notas.R
import br.com.pedro.notas.databinding.ActivityFormularioNotaBinding
import br.com.pedro.notas.model.Notas
import br.com.pedro.notas.ui.adapter.ListaDeNotasAdapter

class FormularioNotaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioNotaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_formulario_salvar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_formulario_salvar -> {
                criaNota()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun criaNota() {
        val titulo = binding.tituloAdd.text.toString()
        val texto = binding.textoAdd.text.toString()
        val novaNota = Notas(
            titulo,
            texto
        )
        val dao = NotasDao

        dao.adiciona(novaNota)
    }


}