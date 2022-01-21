package com.gds.brasilnoticias.ui

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gds.brasilnoticias.R
import com.gds.brasilnoticias.adapter.MainAdapter
import com.gds.brasilnoticias.model.Artigo
import com.gds.brasilnoticias.model.data.FonteDeDadosNoticia
import com.gds.brasilnoticias.presenter.ViewHome
import com.gds.brasilnoticias.presenter.pesquisar.PesquisarPresenter
import com.gds.brasilnoticias.util.UtilQueryTextListner
import kotlinx.android.synthetic.main.activity_pesquisar.*

class PesquisarActivity : AbstractActivity(), ViewHome.View {

    private val searchAdapter by lazy {
        MainAdapter()
    }
    private lateinit var presenter: PesquisarPresenter

    override fun getLayout(): Int = R.layout.activity_pesquisar

    override fun onInject() {
        configPresenter()
        configRecycler()
        pesquisarNoticia()
    }

    private fun configPresenter() {
        val fonteDeDados = FonteDeDadosNoticia()
        presenter = PesquisarPresenter(this, fonteDeDados)
    }

    fun pesquisarNoticia() {
        pesquisarNoticias
            .setOnQueryTextListener(
                UtilQueryTextListner(this.lifecycle) { newText ->
                    newText?.let { query ->
                        validandoQuery(query)
                    }
                }
            )
    }

    private fun validandoQuery(query: String) {
        if (query.isNotEmpty()) {
            presenter.pesquisar(query)
            rvProgressBarTelaPesquisar.visibility = View.VISIBLE
        }
    }

    private fun configRecycler() {
        with(rvPeesquisar) {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(this@PesquisarActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@PesquisarActivity,
                    DividerItemDecoration.VERTICAL
                )
            )

        }

    }

    override fun mostrarBarraDeProgresso() {
        rvProgressBarTelaPesquisar.visibility = View.VISIBLE
    }

    override fun showFalha(mensagem: String) {
        Toast.makeText(this,mensagem,Toast.LENGTH_LONG).show()
    }

    override fun esconderBarraDeProgresso() {
        rvProgressBarTelaPesquisar.visibility = View.INVISIBLE
    }

    override fun mostrarArtigos(artigos: List<Artigo>) {
        searchAdapter.differ.submitList(artigos.toList())
    }

}