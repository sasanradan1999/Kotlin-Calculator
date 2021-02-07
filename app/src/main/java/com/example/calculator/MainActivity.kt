package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.buttons.*
import kotlinx.android.synthetic.main.input_layout.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // numbers
        btn0.setOnClickListener{appendOnClick(true, "0")}
        btn1.setOnClickListener{appendOnClick(true, "1")}
        btn2.setOnClickListener{appendOnClick(true, "2")}
        btn3.setOnClickListener{appendOnClick(true, "3")}
        btn4.setOnClickListener{appendOnClick(true, "4")}
        btn5.setOnClickListener{appendOnClick(true, "5")}
        btn6.setOnClickListener{appendOnClick(true, "6")}
        btn7.setOnClickListener{appendOnClick(true, "7")}
        btn8.setOnClickListener{appendOnClick(true, "8")}
        btn9.setOnClickListener{appendOnClick(true, "9")}
        btnDot.setOnClickListener{appendOnClick(true, ".")}

        // operators
        btnPlus.setOnClickListener{appendOnClick(true, "+")}
        btnMinus.setOnClickListener{appendOnClick(true, "-")}
        btnMultiply.setOnClickListener{appendOnClick(true, "*")}
        btnDivide.setOnClickListener{appendOnClick(true, "/")}
        btnBracketOpen.setOnClickListener{appendOnClick(true, "(")}
        btnBracketClose.setOnClickListener{appendOnClick(true, ")")}

        // IO
        btnCLear.setOnClickListener{
            clear()
        }
        btnEquals.setOnClickListener{
            calculate()
        }
    }

    private fun appendOnClick(clear: Boolean, string: String){
        // if true
        if (clear){
            // set output to blank
            calcOutput.text = ""
            // append string
            calcInput.append(string)
        }else{
            // append output to input
            calcInput.append(calcOutput.text)
            // append string
            calcInput.append(string)
            // set output to blank
            calcOutput.text = ""
        }
    }

    private fun clear(){
        // set input to blank
        calcInput.text = ""
        // set output to blank
        calcOutput.text = ""
    }


    private fun calculate(){
        try {
            val input = ExpressionBuilder(calcInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()

            if (output == longOutput.toDouble()){
                calcOutput.text = longOutput.toString()
            }
            else{
                calcOutput.text = output.toString()
            }

        }catch (e: Exception){
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }
}

