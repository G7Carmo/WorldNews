package com.gds.brasilnoticias.presenter

import com.gds.brasilnoticias.model.Artigo

interface ViewHome {
    interface View{
        fun mostrarBarraDeProgresso()
        fun showFalha(mensagem : String)
        fun esconderBarraDeProgresso()
        fun mostrarArtigos(artigos : List<Artigo>)
    }

}