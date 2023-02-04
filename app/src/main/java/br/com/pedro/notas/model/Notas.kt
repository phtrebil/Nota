package br.com.pedro.notas.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Notas(
    val Título: String,
    val Texto: String
): Parcelable {
}