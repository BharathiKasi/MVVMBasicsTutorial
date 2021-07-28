package com.bharathikasi.mvvmbasicstut.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val mQuoteList = mutableListOf<Quote>()
    private val mQuotesMutableLiveData = MutableLiveData<List<Quote>>()
    init {
        mQuotesMutableLiveData.value = mQuoteList
    }

    fun addNewQuote(pQuote: Quote){
        mQuoteList.add(pQuote)
        mQuotesMutableLiveData.value = mQuoteList
    }
    fun getAllQuote() = mQuotesMutableLiveData as LiveData<List<Quote>>
}