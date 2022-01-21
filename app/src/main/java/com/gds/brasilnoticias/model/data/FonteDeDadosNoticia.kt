package com.gds.brasilnoticias.model.data

import android.media.browse.MediaBrowser
import com.gds.brasilnoticias.network.RetrofitInstancia
import com.gds.brasilnoticias.presenter.noticia.NoticiaInicial
import com.gds.brasilnoticias.presenter.pesquisar.PesquisarInicial
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

    fun pesquisarNoticia(term :String,callback : PesquisarInicial.Presenter){
        GlobalScope.launch (Dispatchers.Main){
            val resposta = RetrofitInstancia.api.pesquisarNoticias(term)
            if (resposta.isSuccessful){
                resposta.body()?.let {newsResponse->
                    callback.sucesso(newsResponse)
                }
                callback.completo()
            }else{
                callback.erro(resposta.message())
                callback.completo()
            }
        }
    }
}