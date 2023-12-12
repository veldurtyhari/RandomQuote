package com.haresh.schools.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haresh.schools.api.QuoteService
import com.haresh.schools.db.QuoteDatabase
import com.haresh.schools.models.School
import com.haresh.schools.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {


    private val quotesLiveData = MutableLiveData<List<School>>()

    val quotes: LiveData<List<School>>
        get() = quotesLiveData

    suspend fun getQuotes(){

     /*   if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
        }*/


        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getSchools()
            //if(result.isEmpty()){
                quoteDatabase.quoteDao().addSchool(result)
                quotesLiveData.postValue(result)
            //}
        }
        else{
            val quoteList = quoteDatabase.quoteDao().getSchool()
            quotesLiveData.postValue(quoteList)
        }

    }
}







