package com.example.trabalhofinal_apptruco

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.trabalhofinal_apptruco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        atualizarEstadoBotao()

        binding.etJogador1.doOnTextChanged { _, _, _, _ -> atualizarEstadoBotao() }
        binding.etJogador2.doOnTextChanged { _, _, _, _ -> atualizarEstadoBotao() }

        binding.botaoComecar.setOnClickListener {
            val nomeJogador1 = binding.etJogador1.text.toString().trim()
            val nomeJogador2 = binding.etJogador2.text.toString().trim()

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


    private fun atualizarEstadoBotao() {
        val textoJogador1 = binding.etJogador1.text.toString().trim()
        val textoJogador2 = binding.etJogador2.text.toString().trim()
        binding.botaoComecar.isEnabled = textoJogador1.isNotEmpty() && textoJogador2.isNotEmpty()
    }
}
