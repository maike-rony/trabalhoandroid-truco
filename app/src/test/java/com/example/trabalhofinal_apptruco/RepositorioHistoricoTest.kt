package com.example.trabalhofinal_apptruco

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class RepositorioHistoricoTest {

    @Before
    fun limparAntesDeCadaTeste() {
        RepositorioHistorico.limpar()
    }

    @After
    fun limparDepoisDeCadaTeste() {
        RepositorioHistorico.limpar()
    }

    @Test
    fun estadoInicialNaoPossuiPartidas() {
        assertTrue(RepositorioHistorico.partidas.isEmpty())
    }

    @Test
    fun doisJogadoresSemVitoriasOuDerrotasMantemHistoricoVazio() {
        RepositorioHistorico.limpar()

        assertTrue(RepositorioHistorico.partidas.none {
            it.vencedor == "Ana" || it.perdedor == "Ana" ||
                it.vencedor == "Bia" || it.perdedor == "Bia"
        })
    }

    @Test
    fun registraVitoriaDoJogador1() {
        RepositorioHistorico.registrarPartida("Ana", "Bia", 12, 8)

        assertEquals(
            listOf(Partida("Ana", "Bia", 12, 8)),
            RepositorioHistorico.partidas
        )
    }

    @Test
    fun registraVitoriaDoJogador2ComMaisDeDozePontos() {
        RepositorioHistorico.registrarPartida("Ana", "Bia", 10, 15)

        assertEquals(1, RepositorioHistorico.partidas.size)
        assertEquals(Partida("Bia", "Ana", 15, 10), RepositorioHistorico.partidas.single())
    }

    @Test
    fun naoRegistraPartidaSemVencedorValido() {
        RepositorioHistorico.registrarPartida("Ana", "Bia", 11, 10)
        RepositorioHistorico.registrarPartida("Ana", "Bia", 12, 12)

        assertTrue(RepositorioHistorico.partidas.isEmpty())
    }

    @Test
    fun permiteRegistrarPartidasEmSequencia() {
        RepositorioHistorico.registrarPartida("Ana", "Bia", 12, 4)
        RepositorioHistorico.registrarPartida("Ana", "Bia", 3, 12)

        assertEquals(2, RepositorioHistorico.partidas.size)
        assertEquals("Ana", RepositorioHistorico.partidas[0].vencedor)
        assertEquals("Bia", RepositorioHistorico.partidas[1].vencedor)
    }

    @Test
    fun limparRemoveTodasAsPartidas() {
        RepositorioHistorico.registrarPartida("Ana", "Bia", 12, 0)
        RepositorioHistorico.registrarPartida("Carlos", "Duda", 0, 12)

        RepositorioHistorico.limpar()

        assertTrue(RepositorioHistorico.partidas.isEmpty())
    }
}
