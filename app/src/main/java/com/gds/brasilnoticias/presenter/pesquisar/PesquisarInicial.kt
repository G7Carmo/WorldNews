package com.gds.brasilnoticias.presenter.pesquisar

import com.gds.brasilnoticias.model.RespostaDaNoticia

interface PesquisarInicial {
    interface Presenter{
        fun pesquisar(termo : String)
        fun sucesso(novaRespostaDaNoticia: RespostaDaNoticia)
        fun erro(mensagem : String)
        fun completo()
    }
}