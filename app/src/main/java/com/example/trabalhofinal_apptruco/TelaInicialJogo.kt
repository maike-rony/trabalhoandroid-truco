package com.example.trabalhofinal_apptruco

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaInicialJogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial_jogo)

        val nomeJogador1 = intent.getStringExtra("EXTRA_JOGADOR_1")?.takeIf { it.isNotBlank() } ?: "Jogador 1"
        val nomeJogador2 = intent.getStringExtra("EXTRA_JOGADOR_2")?.takeIf { it.isNotBlank() } ?: "Jogador 2"

        val tvCabecalhoJogador1 = findViewById<TextView>(R.id.tvCabecalhoJogador1)
        val tvCabecalhoJogador2 = findViewById<TextView>(R.id.tvCabecalhoJogador2)

        tvCabecalhoJogador1.text = getString(R.string.jogador_pontos_format, nomeJogador1, "00")
        tvCabecalhoJogador2.text = getString(R.string.jogador_pontos_format, nomeJogador2, "00")
    }
}
