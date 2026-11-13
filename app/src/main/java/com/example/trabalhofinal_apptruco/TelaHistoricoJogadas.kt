package com.example.trabalhofinal_apptruco

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaHistoricoJogadas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_historico_jogadas)

        val nomeJogador1 = intent.getStringExtra("EXTRA_JOGADOR_1") ?: "Jogador 1"
        val nomeJogador2 = intent.getStringExtra("EXTRA_JOGADOR_2") ?: "Jogador 2"
        val vitoriasJogador1 = intent.getIntExtra("EXTRA_VITORIAS_1", 0)
        val vitoriasJogador2 = intent.getIntExtra("EXTRA_VITORIAS_2", 0)

        val tvCabecalhoJogador1 = findViewById<TextView>(R.id.tvCabecalhoJogador1)
        val tvCabecalhoJogador2 = findViewById<TextView>(R.id.tvCabecalhoJogador2)
        val botaoVoltar = findViewById<Button>(R.id.botaoVoltar)

        tvCabecalhoJogador1.text = getString(R.string.historico_vitorias_format, nomeJogador1, vitoriasJogador1)
        tvCabecalhoJogador2.text = getString(R.string.historico_vitorias_format, nomeJogador2, vitoriasJogador2)

        botaoVoltar.setOnClickListener {
            finish()
        }
    }
}
