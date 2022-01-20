package com.gds.brasilnoticias.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gds.brasilnoticias.R
import com.gds.brasilnoticias.adapter.MainAdapter
import com.gds.brasilnoticias.model.Artigo
import com.gds.brasilnoticias.model.data.FonteDeDadosNoticia
import com.gds.brasilnoticias.presenter.ViewHome
import com.gds.brasilnoticias.presenter.noticia.NoticiaPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity(), ViewHome.View {
    private val mainAdapter by lazy { MainAdapter() }

    private lateinit var presenter: NoticiaPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onInject() {
        configPresenter()
        configRecycler()

    }

    private fun configPresenter() {
        val fonteDeDados = FonteDeDadosNoticia()
        presenter = NoticiaPresenter(this, fonteDeDados)
        presenter.requisitarTudo()
    }

    private fun configRecycler() {
        with(rvMoticias) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun mostrarBarraDeProgresso() {
        rvProgressBar.visibility = View.VISIBLE
    }

    override fun showFalha(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
    }

    override fun esconderBarraDeProgresso() {
        rvProgressBar.visibility = View.INVISIBLE
    }

    override fun mostrarArtigos(artigos: List<Artigo>) {
        mainAdapter.differ.submitList(artigos.toList())

    }

}