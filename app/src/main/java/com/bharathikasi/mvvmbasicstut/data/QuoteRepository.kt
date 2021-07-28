package com.bharathikasi.mvvmbasicstut.data

class QuoteRepository private constructor(private val pQuoteDao: FakeQuoteDao){



    companion object {
        @Volatile private var mInstance:QuoteRepository?= null

        fun getQuoteRepositoryInstance(pQuoteDao: FakeQuoteDao) =
                mInstance ?: synchronized(this){
                    mInstance?: QuoteRepository(pQuoteDao).also { mInstance = it }
                }
    }

    fun addQuote(pQuote: Quote){
        pQuoteDao.addNewQuote(pQuote)
    }
    fun  getAllQuotes() = pQuoteDao.getAllQuote()
}