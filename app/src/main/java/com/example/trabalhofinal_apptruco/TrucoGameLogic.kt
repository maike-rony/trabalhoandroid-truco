package com.example.trabalhofinal_apptruco

class TrucoGameLogic(
    var nomeJogador1: String = "Jogador 1",
    var nomeJogador2: String = "Jogador 2"
) {
    var pontosJogador1: Int = 0
        private set
    var pontosJogador2: Int = 0
        private set
    var vitoriasJogador1: Int = 0
        private set
    var vitoriasJogador2: Int = 0
        private set

    fun adicionarPontosJogador1(pontos: Int): String? {
        pontosJogador1 += pontos
        return verificarVencedor()
    }

    fun adicionarPontosJogador2(pontos: Int): String? {
        pontosJogador2 += pontos
        return verificarVencedor()
    }

    fun verificarVencedor(): String? {
        return when {
            pontosJogador1 >= 12 -> {
                vitoriasJogador1++
                nomeJogador1
            }
            pontosJogador2 >= 12 -> {
                vitoriasJogador2++
                nomeJogador2
            }
            else -> null
        }
    }

    fun zerarPontosPontuacao() {
        pontosJogador1 = 0
        pontosJogador2 = 0
    }

    fun zerarHistorico() {
        pontosJogador1 = 0
        pontosJogador2 = 0
    }

    companion object {
        fun validarNomes(nome1: String, nome2: String): Boolean {
            val n1 = nome1.trim()
            val n2 = nome2.trim()
            if (n1.isEmpty() || n2.isEmpty()) return false
            if (n1.equals(n2, ignoreCase = true)) return false
            return true
        }
    }
}
