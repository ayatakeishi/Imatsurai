package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class TodayConditionActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var radioGroup: RadioGroup
    private lateinit var nextButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_condition)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        radioGroup = findViewById(R.id.radioGroup)
        nextButton = findViewById(R.id.nextButton)
        backButton = findViewById(R.id.backButton)

        // 質問に回答済みかどうかを確認
        if (!sharedPreferences.getBoolean("answeredSutoresuhassanhou", false)) {
            // 回答済みでない場合、前の画面に戻る
            Toast.makeText(this, "前の画面の質問に回答してください", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // 初期状態では次へボタンを無効にする
        nextButton.isEnabled = false

        // 以前の選択を復元する
        val savedRadioButtonId = sharedPreferences.getInt("selectedRadioButtonId", -1)
        if (savedRadioButtonId != -1) {
            radioGroup.check(savedRadioButtonId)
            nextButton.isEnabled = true // 選択が復元された場合、次へボタンを有効にする
        }

        // ラジオボタンにチェック変更リスナーを設定する
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            nextButton.isEnabled = checkedId != -1 // ラジオボタンが選択された場合、次へボタンを有効にする
            Log.d("kyounochoushi", if (checkedId != -1) "Radio button selected: $checkedId" else "Radio button selection cleared")
        }

        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                // 選択されたラジオボタンIDを保存する
                val editor = sharedPreferences.edit()
                editor.putInt("selectedRadioButtonId", selectedRadioButtonId)
                editor.apply()

                Log.d("kyounochoushi", "Next button clicked")
                val intent = Intent(this, MenuSelectActivity::class.java)
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