package com.example.trabalhofinal_apptruco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class TelaInicialJogo : AppCompatActivity() {

    private var pontosJogador1 = 0
    private var pontosJogador2 = 0
    private var vitoriasJogador1 = 0
    private var vitoriasJogador2 = 0

    private var nomeJogador1 = "Jogador 1"
    private var nomeJogador2 = "Jogador 2"

    private lateinit var tvCabecalhoJogador1: TextView
    private lateinit var tvCabecalhoJogador2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial_jogo)

        nomeJogador1 = intent.getStringExtra("EXTRA_JOGADOR_1")?.takeIf { it.isNotBlank() } ?: "Jogador 1"
        nomeJogador2 = intent.getStringExtra("EXTRA_JOGADOR_2")?.takeIf { it.isNotBlank() } ?: "Jogador 2"

        tvCabecalhoJogador1 = findViewById(R.id.tvCabecalhoJogador1)
        tvCabecalhoJogador2 = findViewById(R.id.tvCabecalhoJogador2)

        val botaoJ1Mais1 = findViewById<Button>(R.id.botaoJ1Mais1)
        val botaoJ1Mais3 = findViewById<Button>(R.id.botaoJ1Mais3)
        val botaoJ1Mais6 = findViewById<Button>(R.id.botaoJ1Mais6)
        val botaoJ1Mais9 = findViewById<Button>(R.id.botaoJ1Mais9)
        val botaoJ1Mais12 = findViewById<Button>(R.id.botaoJ1Mais12)

        val botaoJ2Mais1 = findViewById<Button>(R.id.botaoJ2Mais1)
        val botaoJ2Mais3 = findViewById<Button>(R.id.botaoJ2Mais3)
        val botaoJ2Mais6 = findViewById<Button>(R.id.botaoJ2Mais6)
        val botaoJ2Mais9 = findViewById<Button>(R.id.botaoJ2Mais9)
        val botaoJ2Mais12 = findViewById<Button>(R.id.botaoJ2Mais12)

        val botaoHistoricoJogadas = findViewById<Button>(R.id.botaoHistoricoJogadas)
        val botaoZerarHistorico = findViewById<Button>(R.id.botaoZerarHistorico)
        val botaoInformarNomes = findViewById<Button>(R.id.botaoInformarNomes)

        atualizarPlacar()

        botaoJ1Mais1.setOnClickListener { adicionarPontosJogador1(1) }
        botaoJ1Mais3.setOnClickListener { adicionarPontosJogador1(3) }
        botaoJ1Mais6.setOnClickListener { adicionarPontosJogador1(6) }
        botaoJ1Mais9.setOnClickListener { adicionarPontosJogador1(9) }
        botaoJ1Mais12.setOnClickListener { adicionarPontosJogador1(12) }

        botaoJ2Mais1.setOnClickListener { adicionarPontosJogador2(1) }
        botaoJ2Mais3.setOnClickListener { adicionarPontosJogador2(3) }
        botaoJ2Mais6.setOnClickListener { adicionarPontosJogador2(6) }
        botaoJ2Mais9.setOnClickListener { adicionarPontosJogador2(9) }
        botaoJ2Mais12.setOnClickListener { adicionarPontosJogador2(12) }

        botaoHistoricoJogadas.setOnClickListener {
            val intentHistorico = Intent(this, TelaHistoricoJogadas::class.java).apply {
                putExtra("EXTRA_JOGADOR_1", nomeJogador1)
                putExtra("EXTRA_JOGADOR_2", nomeJogador2)
                putExtra("EXTRA_VITORIAS_1", vitoriasJogador1)
                putExtra("EXTRA_VITORIAS_2", vitoriasJogador2)
            }
            startActivity(intentHistorico)
        }

        botaoZerarHistorico.setOnClickListener {
            zerarHistorico()
        }

        botaoInformarNomes.setOnClickListener {
            finish()
        }
    }

    private fun atualizarPlacar() {
        val textoPontos1 = String.format(Locale.getDefault(), "%02d", pontosJogador1)
        val textoPontos2 = String.format(Locale.getDefault(), "%02d", pontosJogador2)
        tvCabecalhoJogador1.text = getString(R.string.jogador_pontos_format, nomeJogador1, textoPontos1)
        tvCabecalhoJogador2.text = getString(R.string.jogador_pontos_format, nomeJogador2, textoPontos2)
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

    private fun verificarVencedor() {
        if (pontosJogador1 >= 12) {
            vitoriasJogador1++
            exibirMensagemVencedor(nomeJogador1)
        } else if (pontosJogador2 >= 12) {
            vitoriasJogador2++
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
        vitoriasJogador1 = 0
        vitoriasJogador2 = 0
        atualizarPlacar()
    }
}
