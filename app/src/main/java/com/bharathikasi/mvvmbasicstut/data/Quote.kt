package com.bharathikasi.mvvmbasicstut.data

data class Quote(val pQuoteText:String, val pAuthor:String){
    override fun toString(): String {
        return "${pQuoteText} - ${pAuthor}"
    }
}