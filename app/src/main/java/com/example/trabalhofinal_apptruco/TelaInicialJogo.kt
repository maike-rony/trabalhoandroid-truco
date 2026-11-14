package com.example.trabalhofinal_apptruco

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalhofinal_apptruco.databinding.ActivityTelaInicialJogoBinding
import kotlin.math.max

class TelaInicialJogo : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialJogoBinding

    private var pontosJogador1 = 0
    private var pontosJogador2 = 0
    private var vitoriasJogador1 = 0
    private var vitoriasJogador2 = 0

    private var nomeJogador1 = "Jogador 1"
    private var nomeJogador2 = "Jogador 2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nomeJogador1 = intent.getStringExtra("EXTRA_JOGADOR_1")?.takeIf { it.isNotBlank() } ?: "Jogador 1"
        nomeJogador2 = intent.getStringExtra("EXTRA_JOGADOR_2")?.takeIf { it.isNotBlank() } ?: "Jogador 2"

        atualizarPlacar()
        atualizarHistorico()

        binding.botaoJ1Mais1.setOnClickListener { adicionarPontosJogador1(1) }
        binding.botaoJ1Mais3.setOnClickListener { adicionarPontosJogador1(3) }
        binding.botaoJ1Mais6.setOnClickListener { adicionarPontosJogador1(6) }
        binding.botaoJ1Mais9.setOnClickListener { adicionarPontosJogador1(9) }
        binding.botaoJ1Mais12.setOnClickListener { adicionarPontosJogador1(12) }

        binding.botaoJ1Menos1.setOnClickListener { subtrairPontosJogador1(1) }
        binding.botaoJ1Menos3.setOnClickListener { subtrairPontosJogador1(3) }
        binding.botaoJ1Menos6.setOnClickListener { subtrairPontosJogador1(6) }
        binding.botaoJ1Menos9.setOnClickListener { subtrairPontosJogador1(9) }
        binding.botaoJ1Menos11.setOnClickListener { subtrairPontosJogador1(11) }

        binding.botaoJ2Mais1.setOnClickListener { adicionarPontosJogador2(1) }
        binding.botaoJ2Mais3.setOnClickListener { adicionarPontosJogador2(3) }
        binding.botaoJ2Mais6.setOnClickListener { adicionarPontosJogador2(6) }
        binding.botaoJ2Mais9.setOnClickListener { adicionarPontosJogador2(9) }
        binding.botaoJ2Mais12.setOnClickListener { adicionarPontosJogador2(12) }

        binding.botaoJ2Menos1.setOnClickListener { subtrairPontosJogador2(1) }
        binding.botaoJ2Menos3.setOnClickListener { subtrairPontosJogador2(3) }
        binding.botaoJ2Menos6.setOnClickListener { subtrairPontosJogador2(6) }
        binding.botaoJ2Menos9.setOnClickListener { subtrairPontosJogador2(9) }
        binding.botaoJ2Menos11.setOnClickListener { subtrairPontosJogador2(11) }

        binding.botaoHistoricoJogadas.setOnClickListener {
            val intentHistorico = Intent(this, TelaHistoricoJogadas::class.java).apply {
                putExtra("EXTRA_JOGADOR_1", nomeJogador1)
                putExtra("EXTRA_JOGADOR_2", nomeJogador2)
                putExtra("EXTRA_VITORIAS_1", vitoriasJogador1)
                putExtra("EXTRA_VITORIAS_2", vitoriasJogador2)
            }
            startActivity(intentHistorico)
        }

        binding.botaoZerarHistorico.setOnClickListener {
            zerarHistorico()
        }

        binding.botaoInformarNomes.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        atualizarHistorico()
    }

    private fun atualizarPlacar() {
        val falta1 = max(0, 12 - pontosJogador1)
        val falta2 = max(0, 12 - pontosJogador2)

        binding.tvCabecalhoJogador1.text = getString(R.string.jogador_nome_pontos_format, nomeJogador1, pontosJogador1)
        binding.tvFaltaJogador1.text = getString(R.string.jogador_falta_format, falta1)

        binding.tvCabecalhoJogador2.text = getString(R.string.jogador_nome_pontos_format, nomeJogador2, pontosJogador2)
        binding.tvFaltaJogador2.text = getString(R.string.jogador_falta_format, falta2)
    }

    private fun atualizarHistorico() {
        val container = binding.root.findViewById<LinearLayout>(R.id.layoutContainerHistorico)
        RepositorioHistorico.popularHistoricoResumo(this, container, nomeJogador1, nomeJogador2)
    }

    private fun adicionarPontosJogador1(pontos: Int) {
        pontosJogador1 += pontos
        atualizarPlacar()
        verificarVencedor()
    }

    private fun adicionarPontosJogador2(pontos: Int) {
        pontosJogador2 += pontos
        atualizarPlacar()
        verificarVencedor()
    }

    private fun subtrairPontosJogador1(pontos: Int) {
        pontosJogador1 = max(0, pontosJogador1 - pontos)
        atualizarPlacar()
    }

    private fun subtrairPontosJogador2(pontos: Int) {
        pontosJogador2 = max(0, pontosJogador2 - pontos)
        atualizarPlacar()
    }

    private fun verificarVencedor() {
        if (pontosJogador1 >= 12) {
            vitoriasJogador1++
            RepositorioHistorico.registrarPartida(nomeJogador1, nomeJogador2, pontosJogador1, pontosJogador2)
            atualizarHistorico()
            exibirMensagemVencedor(nomeJogador1)
        } else if (pontosJogador2 >= 12) {
            vitoriasJogador2++
            RepositorioHistorico.registrarPartida(nomeJogador1, nomeJogador2, pontosJogador1, pontosJogador2)
            atualizarHistorico()
            exibirMensagemVencedor(nomeJogador2)
        }
    }

    private fun exibirMensagemVencedor(nomeVencedor: String) {
        AlertDialog.Builder(this)
            .setTitle(R.string.titulo_fim_jogo)
            .setMessage(getString(R.string.mensagem_vencedor, nomeVencedor))
            .setPositiveButton(R.string.botao_ok) { dialog, _ ->
                zerarPontosPontuacao()
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    private fun zerarPontosPontuacao() {
        pontosJogador1 = 0
        pontosJogador2 = 0
        atualizarPlacar()
    }

    private fun zerarHistorico() {
        pontosJogador1 = 0
        pontosJogador2 = 0
        RepositorioHistorico.limpar()
        atualizarPlacar()
        atualizarHistorico()
        Toast.makeText(this, R.string.pontuacao_jogadores_zerada, Toast.LENGTH_SHORT).show()
    }
}
