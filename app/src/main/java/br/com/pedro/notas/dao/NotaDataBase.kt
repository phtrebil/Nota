package br.com.pedro.notas.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.pedro.notas.model.Notas

@Database(entities = [Notas ::class], version = 1)
abstract class NotaDataBase: RoomDatabase() {

    abstract fun notasDao(): NotasDao

}