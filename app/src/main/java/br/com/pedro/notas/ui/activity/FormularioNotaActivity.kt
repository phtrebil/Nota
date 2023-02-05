package br.com.pedro.notas.ui.activity

import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.com.pedro.notas.R
import br.com.pedro.notas.dao.NotaDataBase
import br.com.pedro.notas.databinding.ActivityFormularioNotaBinding
import br.com.pedro.notas.model.Notas


class FormularioNotaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioNotaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Cria Nota")
        val dadosRecebidos = intent
        if (dadosRecebidos.hasExtra("nota")) {
            setTitle("Edita Nota")
            intent.getParcelableExtra<Notas>("nota")?.let { notaEdita ->
                preencheCampo(notaEdita)
            }

        }

    }

    private fun preencheCampo(notaEdita: Notas) {
        binding.tituloAdd.text = notaEdita.Título.toEditable()
        binding.textoAdd.text = notaEdita.Texto.toEditable()
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_formulario_salvar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_formulario_salvar -> {
                criaNota()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun criaNota() {
        val db = Room.databaseBuilder(
            this,
            NotaDataBase::class.java, "db"
        ).allowMainThreadQueries().build()
        val dadosRecebidos = intent
        var titulo = binding.tituloAdd.text.toString()
        var texto = binding.textoAdd.text.toString()
        val notaNova = Notas(
            0,
            titulo,
            texto
        )

        if (!dadosRecebidos.hasExtra("nota")) {
            db.notasDao().salva(notaNova)
            finish()
        } else {
            db.notasDao().edita(notaNova)
            finish()
        }

    }

}




