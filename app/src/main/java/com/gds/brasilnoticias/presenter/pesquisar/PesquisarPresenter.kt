package com.gds.brasilnoticias.presenter.pesquisar

import com.gds.brasilnoticias.model.RespostaDaNoticia
import com.gds.brasilnoticias.model.data.FonteDeDadosNoticia
import com.gds.brasilnoticias.presenter.ViewHome

class PesquisarPresenter(
    val view : ViewHome.View,
    private val fonteDeDados : FonteDeDadosNoticia
) :PesquisarInicial.Presenter{
    override fun pesquisar(termo: String) {
        TODO("Not yet implemented")
    }

    override fun sucesso(novaRespostaDaNoticia: RespostaDaNoticia) {
        TODO("Not yet implemented")
    }

    override fun erro(mensagem: String) {
        TODO("Not yet implemented")
    }

    override fun completo() {
        TODO("Not yet implemented")
    }
}