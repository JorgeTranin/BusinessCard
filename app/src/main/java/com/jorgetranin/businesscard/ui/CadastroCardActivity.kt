package com.jorgetranin.businesscard.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jorgetranin.businesscard.App
import com.jorgetranin.businesscard.R
import com.jorgetranin.businesscard.data.AppDatabase
import com.jorgetranin.businesscard.data.Card
import com.jorgetranin.businesscard.data.CardDao
import com.jorgetranin.businesscard.databinding.ActivityCadastroCardBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CadastroCardActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var cardDao: CardDao
    lateinit var binding: ActivityCadastroCardBinding
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroCardBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        insertListeners()

    }

    private fun insertListeners() {
        binding.btnCadastrar.setOnClickListener {
            val card = Card(
                nome = binding.etNome.text.toString(),
                empresa = binding.etEmpresa.text.toString(),
                telefone = binding.etTelefone.text.toString(),
                email = binding.etEmail.text.toString(),
                color = binding.tvCor.text.toString()
            )
            mainViewModel.insert(card)
            Toast.makeText(this, "Registro inserido com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}
