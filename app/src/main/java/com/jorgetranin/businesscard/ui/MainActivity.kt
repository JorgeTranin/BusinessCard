package com.jorgetranin.businesscard.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorgetranin.businesscard.App
import com.jorgetranin.businesscard.databinding.ActivityMainBinding
import com.jorgetranin.businesscard.ui.adapter.CardAdapter

class MainActivity : AppCompatActivity()  {
    lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy {
        CardAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        binding.rvCards.setHasFixedSize(true);
        binding.rvCards.setLayoutManager(LinearLayoutManager(this))
        binding.rvCards.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, CadastroCardActivity::class.java)
            startActivity(intent)
        }
        getAllCards()
    }

    private fun getAllCards(){
        mainViewModel.getAll().observe(this, {card ->
            adapter.submitList(card)
        })
    }
}