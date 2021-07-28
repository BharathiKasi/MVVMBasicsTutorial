package com.bharathikasi.mvvmbasicstut.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bharathikasi.mvvmbasicstut.R
import com.bharathikasi.mvvmbasicstut.data.Quote
import com.bharathikasi.mvvmbasicstut.utility.InjectorUtills

class QuotesFeedActivity : AppCompatActivity() {
    private lateinit var mQuotesTv: TextView
    private lateinit var mSaveButton: Button
    private lateinit var mQuoteEditText: EditText
    private lateinit var mAuthorEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes_feed)
        mQuotesTv = findViewById(R.id.textView_quotes)
        mSaveButton = findViewById(R.id.button_add_quote)
        mQuoteEditText = findViewById(R.id.editText_quote)
        mAuthorEditText = findViewById(R.id.editText_author)
        intializeUi()
    }

    fun intializeUi() {
        val lFactory = InjectorUtills.getQuoteViewModelFactoryInstance()
        val lViewModel = ViewModelProvider(this, lFactory).get(QuotesViewModel::class.java)
        lViewModel.getQuotes().observe(this, object : Observer<List<Quote>> {
            override fun onChanged(pQuoteList: List<Quote>?) {
                if (pQuoteList != null && pQuoteList.isNotEmpty()) {
                    var lStringBuilder = StringBuilder()
                    pQuoteList.forEach {
                        lStringBuilder.append("${it}\n\n")
                    }
                    mQuotesTv.text = lStringBuilder
                }

            }

        })
        mSaveButton.setOnClickListener {
            if (mQuoteEditText.text.toString().length > 0) {
                if (mAuthorEditText.text.toString().length > 0) {
                    lViewModel.addQuote(Quote(mQuoteEditText.text.toString(), mAuthorEditText.text.toString()))
                    mQuoteEditText.setText( "")
                    mAuthorEditText.setText("")
                    Toast.makeText(this,"Quote added successfull...",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Please add author name...",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Please add Quote...",Toast.LENGTH_SHORT).show()
            }
        }
    }
}