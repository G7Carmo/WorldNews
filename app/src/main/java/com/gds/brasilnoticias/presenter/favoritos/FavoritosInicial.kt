package com.gds.brasilnoticias.presenter.favoritos

import com.gds.brasilnoticias.model.Artigo
import com.gds.brasilnoticias.model.RespostaDaNoticia

interface FavoritosInicial {
    fun MostrarArtigos(artigos : List<Artigo>)
}