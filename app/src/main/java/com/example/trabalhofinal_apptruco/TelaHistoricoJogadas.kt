package com.example.trabalhofinal_apptruco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalhofinal_apptruco.databinding.ActivityTelaHistoricoJogadasBinding

class TelaHistoricoJogadas : AppCompatActivity() {

    private lateinit var binding: ActivityTelaHistoricoJogadasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaHistoricoJogadasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nomeJogador1 = intent.getStringExtra("EXTRA_JOGADOR_1") ?: "Jogador 1"
        val nomeJogador2 = intent.getStringExtra("EXTRA_JOGADOR_2") ?: "Jogador 2"
        val vitoriasJogador1 = intent.getIntExtra("EXTRA_VITORIAS_1", 0)
        val vitoriasJogador2 = intent.getIntExtra("EXTRA_VITORIAS_2", 0)

        binding.tvCabecalhoJogador1.text = getString(R.string.historico_vitorias_format, nomeJogador1, vitoriasJogador1)
        binding.tvCabecalhoJogador2.text = getString(R.string.historico_vitorias_format, nomeJogador2, vitoriasJogador2)

        binding.botaoVoltar.setOnClickListener {
            finish()
        }
    }
}
