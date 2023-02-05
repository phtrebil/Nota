package br.com.pedro.notas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
class Notas(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val Título: String,
    val Texto: String
): Parcelable {
}