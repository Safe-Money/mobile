package com.example.safemoney.planejamento

import Usuario
import Usuario1
import com.example.safemoney.model.Categoria
import java.time.LocalDate
import java.util.Date

data class PlanejamentoItem(
    val id: Int?,
    val valorPlanejado: Double,
    val totalGasto: Double?,
    val data: String,
    val usuario: Usuario1,
    val categoria: Categoria
)