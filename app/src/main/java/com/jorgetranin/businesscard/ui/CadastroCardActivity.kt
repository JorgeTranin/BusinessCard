package com.jorgetranin.businesscard.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jorgetranin.businesscard.App
import com.jorgetranin.businesscard.data.Card
import com.jorgetranin.businesscard.databinding.ActivityCadastroCardBinding
import yuku.ambilwarna.AmbilWarnaDialog

class CadastroCardActivity : AppCompatActivity() {
    lateinit var binding: ActivityCadastroCardBinding

    private var currentColor = Color.BLUE // cor atual definida como branca

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroCardBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        insertListeners()
        selecionarCor()
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

    private fun selecionarCor() {
        binding.btnColorPickerButton.setOnClickListener {
            // cria uma nova caixa de diálogo de seleção de cor
            val colorPicker = AmbilWarnaDialog(
                this,
                currentColor,
                object : AmbilWarnaDialog.OnAmbilWarnaListener {
                    override fun onCancel(dialog: AmbilWarnaDialog?) {
                        // ação a ser realizada quando o usuário cancela a seleção de cor
                    }

                    override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                        // ação a ser realizada quando o usuário confirma a seleção de cor
                        currentColor = color // atualiza a cor atual
                        // fazer algo com a nova cor selecionada
                        val hexColor = String.format("#%06X", 0xFFFFFF and currentColor)

                        //set do texto, da cor do texto e backgroud para o usuario ver a cor que selecionou
                        binding.tvCor.setBackgroundColor(currentColor)
                        binding.tvCor.setText(hexColor)
                        binding.tvCor.setTextColor(Color.WHITE)
                    }
                })
            colorPicker.show() // exibe a caixa de seleção de cor
        }
    }
}

