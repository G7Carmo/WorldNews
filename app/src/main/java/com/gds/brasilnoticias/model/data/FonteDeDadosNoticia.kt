package com.gds.brasilnoticias.model.data

import android.media.browse.MediaBrowser
import com.gds.brasilnoticias.network.RetrofitInstancia
import com.gds.brasilnoticias.presenter.noticia.NoticiaInicial
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FonteDeDadosNoticia {

    fun getPrincipaisNoticias(callback: NoticiaInicial.Presenter){
        GlobalScope.launch(Dispatchers.Main){
            val resposta = RetrofitInstancia.api.getPrincipaisNoticias("br")
            if (resposta.isSuccessful){
                resposta.body()?.let {respotaComNoticia->
                    callback.sucesso(respotaComNoticia)
                }
                callback.completo()
            }else{
                callback.erro(resposta.message())
                callback.completo()
            }
        }
    }
}