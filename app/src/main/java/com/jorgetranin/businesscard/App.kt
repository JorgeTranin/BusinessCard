package com.jorgetranin.businesscard

import android.app.Application
import com.jorgetranin.businesscard.data.AppDatabase
import com.jorgetranin.businesscard.data.CardRepository

class App: Application() {
    val database by lazy { AppDatabase.getInstance(this) }
    val repository by lazy { CardRepository(database.cardDao()) }
}