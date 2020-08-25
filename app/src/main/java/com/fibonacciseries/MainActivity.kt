package com.fibonacciseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_result.setOnClickListener(this)
    }
    private fun getFibonacciSeries(number: Int) {
        when (number) {
            0 -> {
                tv_result.text = "0"
                return
            }
            1 -> {
                tv_result.text = "1"
                return
            }
            else -> {
                var previous = 0
                var current = 1
                var next: Int
                var result = ""
                result = result.plus(previous).plus(" ").plus(current)
                for ( x in 2 until number){
                    next = previous+current
                    previous = current
                    current = next
                    result = result.plus(" ").plus(current.toString())
                    tv_result.text = getString(R.string.result_is,result)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        if (TextUtils.isEmpty(et_number.text.toString()))
            Toast.makeText(this,getString(R.string.please_enter_number),Toast.LENGTH_SHORT).show()
        else
            getFibonacciSeries(et_number.text.toString().toInt()).toString()
    }
}
