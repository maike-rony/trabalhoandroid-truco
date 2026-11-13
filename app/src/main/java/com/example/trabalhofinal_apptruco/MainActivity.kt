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

        val etPlayer1 = findViewById<EditText>(R.id.etPlayer1)
        val etPlayer2 = findViewById<EditText>(R.id.etPlayer2)
        val btnComecar = findViewById<Button>(R.id.btnComecar)

        fun updateButtonState() {
            val p1 = etPlayer1.text.toString().trim()
            val p2 = etPlayer2.text.toString().trim()
            btnComecar.isEnabled = p1.isNotEmpty() && p2.isNotEmpty()
        }

        updateButtonState()

        etPlayer1.doOnTextChanged { _, _, _, _ -> updateButtonState() }
        etPlayer2.doOnTextChanged { _, _, _, _ -> updateButtonState() }

        btnComecar.setOnClickListener {
            val player1Name = etPlayer1.text.toString().trim()
            val player2Name = etPlayer2.text.toString().trim()

            if (player1Name.equals(player2Name, ignoreCase = true)) {
                Toast.makeText(
                    this,
                    getString(R.string.erro_nomes_iguais),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val intent = Intent(this, TelaInicialJogo::class.java).apply {
                putExtra("EXTRA_PLAYER_1", player1Name)
                putExtra("EXTRA_PLAYER_2", player2Name)
            }
            startActivity(intent)
        }
    }
}
