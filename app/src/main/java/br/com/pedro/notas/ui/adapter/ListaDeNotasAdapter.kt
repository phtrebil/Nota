package br.com.pedro.notas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pedro.notas.databinding.ItemListaDeNotasBinding
import br.com.pedro.notas.model.Notas

class ListaDeNotasAdapter(

    val context: Context,
    notas: List<Notas>
): RecyclerView.Adapter<ListaDeNotasAdapter.NotasViewHolder>() {

    private val notas = notas.toMutableList()

   inner class NotasViewHolder(
       private val binding: ItemListaDeNotasBinding,
   ): RecyclerView.ViewHolder(binding.root) {

       fun vincula(nota: Notas) {
           binding.titulo.text = nota.Título
           binding.textoNota.text = nota.Texto
       }


   }

    fun atualiza(notas: List<Notas>){
        this.notas.clear()
        this.notas.addAll(notas)
        notifyDataSetChanged()
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