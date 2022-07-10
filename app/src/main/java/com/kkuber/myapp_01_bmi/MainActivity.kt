package com.kkuber.myapp_01_bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText : EditText = findViewById(R.id.heightEditText) // EditText로 타입을 주면서 Id를 찾았을 때도 EditText라고 추정
        val weightEditText = findViewById<EditText>(R.id.weightEditText)  // 명시적으로 타입 설정
        val resultButton = findViewById<Button>(R.id.resultBotton)

        // kotlin에서는 interface를 lambda 형식으로 치환해서 바로 사용 가능
        resultButton.setOnClickListener {
            Log.d("MainActivity", "onCreate : resultButton이 클릭되었습니다.")

            // 이 코드 아래로는 빈 값이 올 수 없음.
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 존재합니다.", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
                // @setOnClickListener 이걸 하지 않게 되면 onCreate setOnClickListener 중 어떤 부분에서 return 할 지 모름
                // 추가해줌으로써 setOnClickListener를 빠져나옴.
            }

            val height = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            Log.d("MainActivity", "onCreate : height : $height weight : $weight ")

            val intent = Intent(this, ResultActivity::class.java) // 다음 페이지 설정

            // intent에 값을 담기
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent) // ResultActivity로 넘어감

        }
    }
}