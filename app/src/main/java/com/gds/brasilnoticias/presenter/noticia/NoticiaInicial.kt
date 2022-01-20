package com.gds.brasilnoticias.presenter.noticia

import com.gds.brasilnoticias.model.RespostaDaNoticia

interface NoticiaInicial {
    interface Presenter{
        fun requisitarTudo()
        fun sucesso(novaRespostaDaNoticia: RespostaDaNoticia)
        fun erro(mensagem : String)
        fun completo()
    }
}