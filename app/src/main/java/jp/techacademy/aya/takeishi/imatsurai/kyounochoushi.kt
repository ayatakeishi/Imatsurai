package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class kyounochoushi : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var radioGroup: RadioGroup
    private lateinit var nextButton: Button
    private lateinit var backButton: Button
    private var lastCheckedRadioButtonId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kyounochoushi)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        radioGroup = findViewById(R.id.radioGroup)
        nextButton = findViewById(R.id.nextButton)
        backButton = findViewById(R.id.backButton)

        // 初期状態では次へボタンを無効にする
        nextButton.isEnabled = false

        // 以前の選択を復元する
        val savedRadioButtonId = sharedPreferences.getInt("selectedRadioButtonId", -1)
        if (savedRadioButtonId != -1) {
            radioGroup.check(savedRadioButtonId)
            lastCheckedRadioButtonId = savedRadioButtonId
            nextButton.isEnabled = true // 選択が復元された場合、次へボタンを有効にする
        }

        // ラジオボタンにチェック変更リスナーを設定する
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) {
                nextButton.isEnabled = true // ラジオボタンが選択された場合、次へボタンを有効にする
                lastCheckedRadioButtonId = checkedId
            } else {
                nextButton.isEnabled = false // ラジオボタンの選択をクリアした場合、次へボタンを無効にする
            }
        }

        // ラジオボタンにクリックリスナーを設定する
        for (i in 0 until radioGroup.childCount) {
            val radioButton = radioGroup.getChildAt(i) as RadioButton
            radioButton.setOnClickListener {
                if (radioButton.id == lastCheckedRadioButtonId) {
                    radioGroup.clearCheck()
                }
            }
        }

        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                // 選択されたラジオボタンIDを保存する
                val editor = sharedPreferences.edit()
                editor.putInt("selectedRadioButtonId", selectedRadioButtonId)
                editor.apply()

                Log.d("kyounochoushi", "Next button clicked")
                val intent = Intent(this, menusentaku::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "ラジオボタンを選択してください", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            finish() // 戻るボタンを押した時に現在のアクティビティを終了して前のアクティビティに戻る
        }
    }
}