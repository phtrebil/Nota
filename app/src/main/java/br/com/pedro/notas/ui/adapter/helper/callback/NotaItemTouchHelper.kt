package br.com.pedro.notas.ui.adapter.helper.callback

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.pedro.notas.dao.NotasDao
import br.com.pedro.notas.ui.adapter.ListaDeNotasAdapter

class NotaItemTouchHelper(

    private val adapter: ListaDeNotasAdapter? = null

) : ItemTouchHelper.Callback() {


    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val marcacoesDeDeslize = ItemTouchHelper.START or ItemTouchHelper.END
        val marcacoesDeArrastar =
            ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(marcacoesDeArrastar, marcacoesDeDeslize)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val posicaoInicial: Int = viewHolder.adapterPosition
        val posicaoFinal: Int = target.adapterPosition
        trocaNotas(posicaoInicial, posicaoFinal)
        return true
    }

    private fun trocaNotas(posicaoInicial: Int, posicaoFinal: Int) {
        NotasDao().troca(posicaoInicial, posicaoFinal)
        adapter?.troca(posicaoInicial, posicaoFinal)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val itemDeslizado = viewHolder.adapterPosition
        removeItem(itemDeslizado)
    }

    private fun removeItem(item: Int) {
        NotasDao.remove(item)
        adapter?.remove(item)
    }
}