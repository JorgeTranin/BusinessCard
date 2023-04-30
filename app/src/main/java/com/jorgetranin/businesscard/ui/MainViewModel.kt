package com.jorgetranin.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jorgetranin.businesscard.data.Card
import com.jorgetranin.businesscard.data.CardRepository
import java.lang.IllegalArgumentException

class MainViewModel(private val cardRepository: CardRepository): ViewModel() {

    fun insert(card: Card){
        cardRepository.insert(card)
    }

    fun getAll(): LiveData<List<Card>>{
        return cardRepository.getAll()
    }
}

class MainViewModelFactory(private val cardRepository: CardRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){

            @Suppress("UNCHECKED_CAST")
            return MainViewModel(cardRepository) as T
        }
        throw IllegalArgumentException("uknow MainVieModel")

    }

}