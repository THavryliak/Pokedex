package com.example.pokedex.Model

import androidx.core.net.toUri

data class PokeData(val name: String, val url: String) {

    fun getImageUrl(): String {
        val id: String  = url.toUri().lastPathSegment ?: ""
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    }
}