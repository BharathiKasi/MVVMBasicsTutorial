package com.bharathikasi.mvvmbasicstut.utility

import com.bharathikasi.mvvmbasicstut.data.FakeDataBase
import com.bharathikasi.mvvmbasicstut.data.QuoteRepository
import com.bharathikasi.mvvmbasicstut.ui.quotes.QuotesViewModelFactory

object InjectorUtills {

    fun getQuoteViewModelFactoryInstance():QuotesViewModelFactory {
        val mQuoteRepository = QuoteRepository.getQuoteRepositoryInstance(FakeDataBase.getFakeDataBaseInstance().mFakeQuoteDao)
        return QuotesViewModelFactory(mQuoteRepository)
    }
}