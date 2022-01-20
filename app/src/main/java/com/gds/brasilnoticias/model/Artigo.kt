package com.gds.brasilnoticias.model

import java.io.Serializable

data class Artigo(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Fonte?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
):Serializable