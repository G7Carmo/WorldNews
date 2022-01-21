package com.gds.brasilnoticias.presenter.favoritos

import com.gds.brasilnoticias.model.Artigo
import com.gds.brasilnoticias.model.data.NewsDataSource
import com.gds.brasilnoticias.presenter.ViewHome

class FavoritosPresenter(
    val view: ViewHome.Favoritos,
    private val fonteDeDados: NewsDataSource
) : FavoritosInicial.Presenter {

    fun salvarArtigo(artigo: Artigo) {
        this.fonteDeDados.savalArtigo(artigo)
    }

    fun getAll() {
        this.fonteDeDados.getAllArtigos(this)
    }

    override fun sucesso(artigos: List<Artigo>) {
        this.view.mostrarArtigos(artigos)
    }

    fun deleteArtigo(artigo: Artigo?) {
        this.fonteDeDados.deletarArtigo(artigo)
    }
}