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

class FormularioNotaActivity : AppCompatActivity() {

    private val dao = NotasDao
    private val binding by lazy {
        ActivityFormularioNotaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

