package com.gds.brasilnoticias.presenter.pesquisar

import com.gds.brasilnoticias.model.RespostaDaNoticia
import com.gds.brasilnoticias.model.data.FonteDeDadosNoticia
import com.gds.brasilnoticias.presenter.ViewHome

class PesquisarPresenter(
    val view : ViewHome.View,
    private val fonteDeDados : FonteDeDadosNoticia
) :PesquisarInicial.Presenter{
    override fun pesquisar(termo: String) {
        this.view.mostrarBarraDeProgresso()
        this.fonteDeDados.pesquisarNoticia(termo,this)
    }

    override fun sucesso(novaRespostaDaNoticia: RespostaDaNoticia) {
        this.view.mostrarArtigos(novaRespostaDaNoticia.articles)
    }

    override fun erro(mensagem: String) {
        this.view.showFalha(mensagem)
    }

    override fun completo() {
        this.view.esconderBarraDeProgresso()
    }
}