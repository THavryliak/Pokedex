package com.example.pokedex.model

import androidx.core.net.toUri

data class PokeData(val name: String, val url: String) {

    fun getImageUrl(): String {
        val id: String  = url.toUri().lastPathSegment ?: ""
        return "https://pokeres.bastionbot.org/images/pokemon/$id.png"
    }
}