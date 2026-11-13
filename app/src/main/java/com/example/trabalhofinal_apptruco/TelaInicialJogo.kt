package com.example.trabalhofinal_apptruco

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaInicialJogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial_jogo)

        val player1Name = intent.getStringExtra("EXTRA_PLAYER_1")?.takeIf { it.isNotBlank() } ?: "Jogador 1"
        val player2Name = intent.getStringExtra("EXTRA_PLAYER_2")?.takeIf { it.isNotBlank() } ?: "Jogador 2"

        val tvJogador1Header = findViewById<TextView>(R.id.tvJogador1Header)
        val tvJogador2Header = findViewById<TextView>(R.id.tvJogador2Header)

        tvJogador1Header.text = getString(R.string.jogador_pontos_format, player1Name, "00")
        tvJogador2Header.text = getString(R.string.jogador_pontos_format, player2Name, "00")
    }
}
