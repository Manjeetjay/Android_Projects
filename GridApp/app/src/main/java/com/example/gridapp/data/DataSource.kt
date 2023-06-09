package com.example.gridapp.data

import com.example.gridapp.R
import com.example.gridapp.model.Grid

class Datasource() {
    fun loadGrid(): List<Grid> {
        return listOf(
            Grid(R.string.architecture, R.integer.architecture, R.drawable.architecture),
            Grid(R.string.crafts, R.integer.crafts, R.drawable.crafts),
            Grid(R.string.business, R.integer.buisness, R.drawable.business),
            Grid(R.string.culinary, R.integer.culinary, R.drawable.culinary),
            Grid(R.string.design, R.integer.design, R.drawable.design),
            Grid(R.string.fashion, R.integer.fashion, R.drawable.fashion),
            Grid(R.string.film, R.integer.film, R.drawable.film),
            Grid(R.string.gaming, R.integer.gaming, R.drawable.gaming),
            Grid(R.string.drawing, R.integer.drawing, R.drawable.drawing),
            Grid(R.string.lifestyle, R.integer.lifestyle, R.drawable.lifestyle),
            Grid(R.string.music, R.integer.music, R.drawable.music),
            Grid(R.string.painting, R.integer.painting, R.drawable.painting),
            Grid(R.string.photography, R.integer.photography, R.drawable.photography),
            Grid(R.string.tech, R.integer.tech, R.drawable.tech)
        )
    }
}