package com.example.trabalhofinal_apptruco

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.widget.LinearLayout
import android.widget.TextView

data class Partida(
    val vencedor: String,
    val perdedor: String,
    val pontosVencedor: Int,
    val pontosPerdedor: Int
)

object RepositorioHistorico {
    val partidas = mutableListOf<Partida>()

    fun registrarPartida(nome1: String, nome2: String, pontos1: Int, pontos2: Int) {
        if (pontos1 >= 12 && pontos1 > pontos2) {
            partidas.add(Partida(vencedor = nome1, perdedor = nome2, pontosVencedor = pontos1, pontosPerdedor = pontos2))
        } else if (pontos2 >= 12 && pontos2 > pontos1) {
            partidas.add(Partida(vencedor = nome2, perdedor = nome1, pontosVencedor = pontos2, pontosPerdedor = pontos1))
        }
    }

    fun limpar() {
        partidas.clear()
    }

    @SuppressLint("SetTextI18n")
    fun popularHistoricoResumo(context: Context, container: LinearLayout, vararg jogadores: String) {
        container.removeAllViews()
        val jogadoresUnicos = jogadores.distinct()

        val existePartidaParaAlgumJogador = jogadoresUnicos.any { jogador ->
            partidas.any { it.vencedor == jogador || it.perdedor == jogador }
        }
        if (!existePartidaParaAlgumJogador) {
            val tvVazio = TextView(context).apply {
                text = context.getString(R.string.historico_sem_partidas)
                textSize = 16f
                setTextColor(context.getColor(R.color.truco_texto_secundario))
                setPadding(0, 16, 0, 12)
            }
            container.addView(tvVazio)
            return
        }

        for (jogador in jogadoresUnicos) {
            val partidasDoJogador = partidas.filter {
                it.vencedor == jogador || it.perdedor == jogador
            }
            val vitorias = partidasDoJogador.count { it.vencedor == jogador }
            val derrotas = partidasDoJogador.count { it.perdedor == jogador }

            val tvHeader = TextView(context).apply {
                text = buildString {
                    append(jogador)
                    append(" (")
                    append(vitorias)
                    append(" vitória")
                    append(if (vitorias == 1) "" else "s")
                    append(" / ")
                    append(derrotas)
                    append(" derrota")
                    append(if (derrotas == 1) "" else "s")
                    append(")")
                }
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(context.getColor(R.color.truco_texto))
                this.setPadding(0, 16, 0, 4)
            }
            container.addView(tvHeader)

            if (partidasDoJogador.isEmpty()) {
                val tvVazio = TextView(context).apply {
                    text = "Nenhuma partida registrada."
                    textSize = 14f
                    setTextColor(context.getColor(R.color.truco_texto_secundario))
                    setPadding(0, 0, 0, 12)
                }
                container.addView(tvVazio)
            } else {
                for ((vencedor, perdedor, pontosVencedor, pontosPerdedor) in partidasDoJogador) {
                    val textPartida = if (vencedor == jogador) {
                        "$jogador venceu $perdedor por ${pontosVencedor}x$pontosPerdedor"
                    } else {
                        "$jogador perdeu para $vencedor por ${pontosPerdedor}x$pontosVencedor"
                    }
                    val tvPartida = TextView(context).apply {
                        text = textPartida
                        textSize = 14f
                        setTextColor(context.getColor(R.color.truco_texto))
                        setPadding(0, 2, 0, 2)
                    }
                    container.addView(tvPartida)
                }
            }
        }
    }
}
