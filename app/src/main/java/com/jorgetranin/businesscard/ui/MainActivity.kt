package com.jorgetranin.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.jorgetranin.businesscard.R
import com.jorgetranin.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, CadastroCardActivity::class.java)
            startActivity(intent)
        }
    }
}