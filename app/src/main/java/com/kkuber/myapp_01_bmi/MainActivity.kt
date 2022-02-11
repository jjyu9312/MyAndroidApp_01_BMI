package com.kkuber.myapp_01_bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText : EditText = findViewById(R.id.heightEditText) // EditText로 타입을 주면서 Id를 찾았을 때도 EditText라고 추정
        val weightEditText = findViewById<EditText>(R.id.weightEditText)  // 명시적으로 타입 설
        val resultButton = findViewById<Button>(R.id.resultBotton)

    }
}