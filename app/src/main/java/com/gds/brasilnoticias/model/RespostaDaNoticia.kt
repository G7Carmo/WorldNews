package com.gds.brasilnoticias.model

data class RespostaDaNoticia(
    val articles: MutableList<Artigo>,
    val status: String,
    val totalResults: Int
)