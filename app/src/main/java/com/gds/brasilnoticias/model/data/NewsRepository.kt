package com.gds.brasilnoticias.model.data

import com.gds.brasilnoticias.model.Artigo
import com.gds.brasilnoticias.model.db.ArtigoDataBase

class NewsRepository(private val db : ArtigoDataBase) {

    suspend fun updateInsert(artigo: Artigo) = db.getArtigoDao().updateInsert(artigo)

    fun getAll() : List<Artigo> = db.getArtigoDao().getAll()

    suspend fun delete(artigo: Artigo) = db.getArtigoDao().delete(artigo)
}