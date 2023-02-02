package br.com.pedro.notas.Dao

import br.com.pedro.notas.model.Notas
import java.util.*

class NotasDao {
    fun buscaTudo(): List<Notas> {
        return notas.toList()
    }

    fun adiciona(nota: Notas) {
        notas.add(nota)
    }

    fun remove(posicao: Int) {
        notas.removeAt(posicao)
    }

    fun troca(posicaoInicial: Int, posicaoFinal: Int) {
        Collections.swap(notas, posicaoInicial, posicaoFinal);

    }


    companion object {

        fun adiciona(nota: Notas) {
            notas.add(nota)
        }

        fun remove(posicao: Int) {
            notas.removeAt(posicao)
        }

        private val notas = mutableListOf<Notas>(
            Notas(
                "Título",
                "@tools:sample/lorem/random"
            ),
            Notas(
                "Título",
                "@tools:sample/lorem/random"
            ),
            Notas(
                "Título",
                "@tools:sample/lorem/random"
            )
        )

    }


}
