package br.com.pedro.notas.Dao

import br.com.pedro.notas.model.Notas

class NotasDao {

    fun adiciona(nota: Notas) {
        notas.add(nota)
    }

    fun buscaTudo(): List<Notas> {
        return notas.toList()
    }

    companion object {
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