package com.bharathikasi.mvvmbasicstut.ui.quotes

import androidx.lifecycle.ViewModel
import com.bharathikasi.mvvmbasicstut.data.Quote
import com.bharathikasi.mvvmbasicstut.data.QuoteRepository

class QuotesViewModel(private val pQuoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = pQuoteRepository.getAllQuotes()

    fun addQuote(pQuote: Quote){
        pQuoteRepository.addQuote(pQuote)
    }
}