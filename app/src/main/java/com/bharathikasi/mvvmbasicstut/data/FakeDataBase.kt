package com.bharathikasi.mvvmbasicstut.data

class FakeDataBase private constructor(){

    var mFakeQuoteDao:FakeQuoteDao = FakeQuoteDao()
    private set
    companion object {
        @Volatile private var mInstance:FakeDataBase?= null

        fun getFakeDataBaseInstance() =
                mInstance ?: synchronized(this){
                    mInstance?: FakeDataBase().also { mInstance = it }
                }
    }
}