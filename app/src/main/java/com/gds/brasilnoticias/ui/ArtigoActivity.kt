package com.gds.brasilnoticias.ui

import android.webkit.WebViewClient
import com.gds.brasilnoticias.R
import com.gds.brasilnoticias.model.Artigo
import com.gds.brasilnoticias.model.data.NewsDataSource
import com.gds.brasilnoticias.presenter.ViewHome
import com.gds.brasilnoticias.presenter.favoritos.FavoritosPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_artigo.*

class ArtigoActivity : AbstractActivity() ,ViewHome.Favoritos{

    private lateinit var artigo: Artigo
    private lateinit var presenter : FavoritosPresenter

    override fun getLayout(): Int = R.layout.activity_artigo

    override fun onInject() {
        getArtigo()
        configWebView()
        configPresenter()
        fabListner()
    }

    private fun fabListner() {
        fab.setOnClickListener {
            presenter.salvarArtigo(artigo)
            Snackbar.make(
                it,
                R.string.article_saved_successful,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun configPresenter() {
        val fonteDeDados = NewsDataSource(this)
        presenter = FavoritosPresenter(this,fonteDeDados)
    }

    private fun getArtigo() {
        intent.extras?.let { artigoRecebido ->
            artigo = artigoRecebido.get("artigo") as Artigo
        }
    }

    private fun configWebView() {
        webView.apply {
            webViewClient = WebViewClient()
            artigo.url?.let { url ->
                loadUrl(url)
            }
        }
    }

    override fun mostrarArtigos(artigos: List<Artigo>) {}

}