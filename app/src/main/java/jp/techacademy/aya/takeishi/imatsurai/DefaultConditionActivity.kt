package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DefaultConditionActivity : AppCompatActivity() {
    private var lastCheckedRadioButtonId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default_condition)

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
                val intent = Intent(this, WayOfReleaseStressActivity::class.java)
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