package com.example.trabalhofinal_apptruco

import android.os.Bundle
import android.widget.LinearLayout
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

        carregarHistorico(nomeJogador1, nomeJogador2)

        binding.botaoVoltar.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        val nomeJogador1 = intent.getStringExtra("EXTRA_JOGADOR_1") ?: "Jogador 1"
        val nomeJogador2 = intent.getStringExtra("EXTRA_JOGADOR_2") ?: "Jogador 2"
        carregarHistorico(nomeJogador1, nomeJogador2)
    }

    private fun carregarHistorico(nome1: String, nome2: String) {
        val container = binding.root.findViewById<LinearLayout>(R.id.layoutContainerHistorico)
        RepositorioHistorico.popularHistoricoResumo(this, container, nome1, nome2)
    }
}
