package com.haresh.schools

import android.app.Application
import com.haresh.schools.api.QuoteService
import com.haresh.schools.api.RetrofitHelper
import com.haresh.schools.db.QuoteDatabase
import com.haresh.schools.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}