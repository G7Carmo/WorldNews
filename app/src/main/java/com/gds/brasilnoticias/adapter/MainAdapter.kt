package com.gds.brasilnoticias.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gds.brasilnoticias.R
import com.gds.brasilnoticias.model.Artigo
import kotlinx.android.synthetic.main.item_noticia.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ArtigoViewHolder>() {
    inner class ArtigoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object  : DiffUtil.ItemCallback<Artigo>(){
        override fun areItemsTheSame(oldItem: Artigo, newItem: Artigo): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Artigo, newItem: Artigo): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtigoViewHolder  =
        ArtigoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_noticia,parent,false)
        )

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ArtigoViewHolder, position: Int) {
        val artigo = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(artigo.urlToImage).into(ivArtigoImagem)
            tvTitulo.text = artigo.author ?: artigo.source?.name
            tvSource.text = artigo.source?.name ?: artigo.author
            tvDescricao.text = artigo.description
            tvDataDePublicacao.text = artigo.publishedAt
            setOnClickListener {
                onIntemClickListener?.let {click->
                    click(artigo)
                }
            }
        }
    }

    private var onIntemClickListener : ((Artigo) -> Unit)? = null

    fun setOnClickListner(listner : (Artigo) -> Unit){
        onIntemClickListener = listner
    }
}