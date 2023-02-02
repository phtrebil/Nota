package br.com.pedro.notas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pedro.notas.databinding.ItemListaDeNotasBinding
import br.com.pedro.notas.model.Notas

class ListaDeNotasAdapter(

    val context: Context,
    val notas: List<Notas>
): RecyclerView.Adapter<ListaDeNotasAdapter.NotasViewHolder>() {

   inner class NotasViewHolder(
       private val binding: ItemListaDeNotasBinding,
   ): RecyclerView.ViewHolder(binding.root) {

       fun vincula(nota: Notas) {
           binding.titulo.text = nota.Título
           binding.textoNota.text = nota.Texto
       }


   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        val inflater = LayoutInflater.from(context)
        return NotasViewHolder(ItemListaDeNotasBinding.inflate(inflater, parent,false))
    }

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        val nota = notas[position]
        holder.vincula(nota)
    }

    override fun getItemCount(): Int = notas.size

}