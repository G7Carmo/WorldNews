package com.gds.brasilnoticias.presenter.favoritos

import com.gds.brasilnoticias.model.Artigo
import com.gds.brasilnoticias.model.RespostaDaNoticia

interface FavoritosInicial {

    interface Presenter{
        fun sucesso(artigos : List<Artigo>)
    }
}