package com.example.trabalhofinal_apptruco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etJogador1 = findViewById<EditText>(R.id.etJogador1)
        val etJogador2 = findViewById<EditText>(R.id.etJogador2)
        val botaoComecar = findViewById<Button>(R.id.botaoComecar)

        fun atualizarEstadoBotao() {
            val textoJogador1 = etJogador1.text.toString().trim()
            val textoJogador2 = etJogador2.text.toString().trim()
            botaoComecar.isEnabled = textoJogador1.isNotEmpty() && textoJogador2.isNotEmpty()
        }

        atualizarEstadoBotao()

        etJogador1.doOnTextChanged { _, _, _, _ -> atualizarEstadoBotao() }
        etJogador2.doOnTextChanged { _, _, _, _ -> atualizarEstadoBotao() }

        botaoComecar.setOnClickListener {
            val nomeJogador1 = etJogador1.text.toString().trim()
            val nomeJogador2 = etJogador2.text.toString().trim()

            if (nomeJogador1.equals(nomeJogador2, ignoreCase = true)) {
                Toast.makeText(
                    this,
                    getString(R.string.erro_nomes_iguais),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val intentNavegacao = Intent(this, TelaInicialJogo::class.java).apply {
                putExtra("EXTRA_JOGADOR_1", nomeJogador1)
                putExtra("EXTRA_JOGADOR_2", nomeJogador2)
            }
            startActivity(intentNavegacao)
        }
    }
}
