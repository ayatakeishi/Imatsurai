package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class sutoresuhassanhou : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private var lastCheckedRadioButtonId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sutoresuhassanhou)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val backButton = findViewById<Button>(R.id.backButton)

        // ラジオボタンにクリックリスナーを設定する
        for (i in 0 until radioGroup.childCount) {
            val radioButton = radioGroup.getChildAt(i) as RadioButton
            radioButton.setOnClickListener {
                if (radioButton.id == lastCheckedRadioButtonId) {
                    radioGroup.clearCheck()
                    lastCheckedRadioButtonId = -1
                } else {
                    lastCheckedRadioButtonId = radioButton.id
                }
            }
        }

        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                // 回答済みのフラグを立てる
                val editor = sharedPreferences.edit()
                editor.putBoolean("answeredSutoresuhassanhou", true)
                editor.apply()

                val intent = Intent(this, kyounochoushi::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "ラジオボタンを選択してください", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}