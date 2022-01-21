package com.gds.brasilnoticias.model.db

import androidx.room.*
import com.gds.brasilnoticias.model.Artigo

@Dao
interface ArtigoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInsert(artigo: Artigo) : Long

    @Query("SELECT* FROM artigo")
    fun getAll(): List<Artigo>

    @Delete
    suspend fun delete(artigo: Artigo)


}