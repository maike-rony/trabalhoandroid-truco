package com.example.trabalhofinal_apptruco

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class TrucoGameLogicTest {

    private lateinit var logicaJogo: TrucoGameLogic

    @Before
    fun setup() {
        logicaJogo = TrucoGameLogic("Maike", "Rony")
    }

    @Test
    fun testarEstadoInicial() {
        assertEquals("Maike", logicaJogo.nomeJogador1)
        assertEquals("Rony", logicaJogo.nomeJogador2)
        assertEquals(0, logicaJogo.pontosJogador1)
        assertEquals(0, logicaJogo.pontosJogador2)
        assertEquals(0, logicaJogo.vitoriasJogador1)
        assertEquals(0, logicaJogo.vitoriasJogador2)
    }

    @Test
    fun testarAdicaoPontosJogador1() {
        val vencedor = logicaJogo.adicionarPontosJogador1(3)
        assertEquals(3, logicaJogo.pontosJogador1)
        assertNull(vencedor)
    }

    @Test
    fun testarAdicaoPontosJogador2() {
        val vencedor = logicaJogo.adicionarPontosJogador2(6)
        assertEquals(6, logicaJogo.pontosJogador2)
        assertNull(vencedor)
    }

    @Test
    fun testarSubtracaoPontosJogador1NaoBaixaDeZero() {
        logicaJogo.adicionarPontosJogador1(3)
        logicaJogo.subtrairPontosJogador1(5)
        assertEquals(0, logicaJogo.pontosJogador1)
    }

    @Test
    fun testarSubtracaoPontosJogador2() {
        logicaJogo.adicionarPontosJogador2(9)
        logicaJogo.subtrairPontosJogador2(3)
        assertEquals(6, logicaJogo.pontosJogador2)
    }

    @Test
    fun testarSubtracaoDeOnzePontos() {
        logicaJogo.adicionarPontosJogador1(12)
        logicaJogo.subtrairPontosJogador1(11)
        assertEquals(1, logicaJogo.pontosJogador1)

        logicaJogo.adicionarPontosJogador2(5)
        logicaJogo.subtrairPontosJogador2(11)
        assertEquals(0, logicaJogo.pontosJogador2)
    }

    @Test
    fun testarVitoriaJogador1Atingir12Pontos() {
        logicaJogo.adicionarPontosJogador1(9)
        val vencedor = logicaJogo.adicionarPontosJogador1(3)
        assertEquals(12, logicaJogo.pontosJogador1)
        assertEquals("Maike", vencedor)
        assertEquals(1, logicaJogo.vitoriasJogador1)
    }

    @Test
    fun testarVitoriaJogador2Atingir12Pontos() {
        val vencedor = logicaJogo.adicionarPontosJogador2(12)
        assertEquals(12, logicaJogo.pontosJogador2)
        assertEquals("Rony", vencedor)
        assertEquals(1, logicaJogo.vitoriasJogador2)
    }

    @Test
    fun testarZerarPontosMantemVitorias() {
        logicaJogo.adicionarPontosJogador1(12)
        assertEquals(1, logicaJogo.vitoriasJogador1)

        logicaJogo.zerarPontosPontuacao()
        assertEquals(0, logicaJogo.pontosJogador1)
        assertEquals(1, logicaJogo.vitoriasJogador1)
    }

    @Test
    fun testarZerarHistoricoZeraPontosMantemVitorias() {
        logicaJogo.adicionarPontosJogador1(12)
        assertEquals(1, logicaJogo.vitoriasJogador1)

        logicaJogo.zerarHistorico()
        assertEquals(0, logicaJogo.pontosJogador1)
        assertEquals(0, logicaJogo.pontosJogador2)
        assertEquals(1, logicaJogo.vitoriasJogador1)
    }

    @Test
    fun testarValidacaoNomesValidos() {
        assertTrue(TrucoGameLogic.validarNomes("Jogador 1", "Jogador 2"))
    }

    @Test
    fun testarValidacaoNomesVazios() {
        assertFalse(TrucoGameLogic.validarNomes("", "Jogador 2"))
        assertFalse(TrucoGameLogic.validarNomes("Jogador 1", "   "))
    }

    @Test
    fun testarValidacaoNomesIguais() {
        assertFalse(TrucoGameLogic.validarNomes("Maike", "maike"))
    }
}
