package com.example.trabalhofinal_apptruco

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.max

class TrucoPontoLogicTest {

    @Test
    fun testarCalculoPontosFaltantes() {
        val pontosIniciais = 0
        val faltaIncial = max(0, 12 - pontosIniciais)
        assertEquals(12, faltaIncial)

        val pontosParciais = 3
        val faltaParcial = max(0, 12 - pontosParciais)
        assertEquals(9, faltaParcial)

        val pontosVitoria = 12
        val faltaVitoria = max(0, 12 - pontosVitoria)
        assertEquals(0, faltaVitoria)

        val pontosAcima = 15
        val faltaAcima = max(0, 12 - pontosAcima)
        assertEquals(0, faltaAcima)
    }
}
