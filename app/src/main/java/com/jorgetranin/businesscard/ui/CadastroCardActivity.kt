package com.jorgetranin.businesscard.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.jorgetranin.businesscard.databinding.ActivityCadastroCardBinding

class CadastroCardActivity : AppCompatActivity() {

    lateinit var binding: ActivityCadastroCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroCardBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        insertListeners()

    }

    fun insertListeners() {
        binding.btnClose.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCadastrar.setOnClickListener {

        }
    }
}