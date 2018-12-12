package kr.ac.skuniv.choejun_yeong.boostcamp3.model

data class ReponseMovie(
        val total: Int,
        val start: Int,
        val display: Int,
        val items: List<Movie>
)