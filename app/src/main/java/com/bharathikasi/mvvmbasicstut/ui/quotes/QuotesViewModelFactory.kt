package com.bharathikasi.mvvmbasicstut.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bharathikasi.mvvmbasicstut.data.QuoteRepository

class QuotesViewModelFactory(private val pQuoteRepository: QuoteRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(pQuoteRepository = pQuoteRepository) as T
    }
}