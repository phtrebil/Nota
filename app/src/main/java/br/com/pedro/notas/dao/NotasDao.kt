package br.com.pedro.notas.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.pedro.notas.model.Notas
@Dao
interface NotasDao {

    @Query("SELECT * FROM Notas")
    fun bustaTudo(): List<Notas>

    @Query("SELECT * FROM Notas WHERE id IN (:userIds)")
    fun buscaPeloId(userIds: IntArray): List<Notas>

    @Insert
    fun salva(vararg notas: Notas)

    @Delete
    fun delete(notas: Notas)

    @Update
    fun edita (notas: Notas)
}
