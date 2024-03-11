package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.function.BinaryOperator

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        buttonAdd = findViewById(R.id.btn_add)
        buttonSub = findViewById(R.id.btn_sub)
        buttonMul = findViewById(R.id.btn_mul)
        buttonDiv = findViewById(R.id.btn_div)
        editText1 = findViewById(R.id.number1)
        editText2 = findViewById(R.id.number2)
        textView = findViewById(R.id.answer)

        // Set click listeners for operation buttons
        buttonAdd.setOnClickListener { performOperation("+") }
        buttonSub.setOnClickListener { performOperation("-") }
        buttonMul.setOnClickListener { performOperation("×") }
        buttonDiv.setOnClickListener { performOperation("÷") }

        // Rest of your code...
    }

    private fun performOperation(operator: String) {
        val number1Str = editText1.text.toString()
        val number2Str = editText2.text.toString()

        if (number1Str.isNotEmpty() && number2Str.isNotEmpty()) {
            val num1 = number1Str.toDouble()
            val num2 = number2Str.toDouble()

            val result: Double = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "×" -> num1 * num2
                "÷" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> Double.NaN
            }

            // Display the result in the TextView
            textView.text = "Result: $result"
        } else {
            // Handle empty input case
            textView.text = "Enter valid numbers"
        }
    }
}