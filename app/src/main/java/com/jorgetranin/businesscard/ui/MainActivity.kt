package com.jorgetranin.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.jorgetranin.businesscard.App
import com.jorgetranin.businesscard.R
import com.jorgetranin.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        getAllCards()
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, CadastroCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllCards(){
        mainViewModel.getAll().observe(this, {card ->

        })
    }
}