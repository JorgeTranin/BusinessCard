package com.jorgetranin.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CardRepository(private val dao: CardDao) {
    fun insert(card: Card) = runBlocking {
        launch (Dispatchers.IO){
            dao.insert(card)

        }
    }
    fun getAll() = dao.getAll()
}