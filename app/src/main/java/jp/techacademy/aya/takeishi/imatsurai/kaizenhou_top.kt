package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class kaizenhou_top : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kaizenhou_top)

        val nextButton = findViewById<Button>(R.id.nextButton)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButtonYes = findViewById<RadioButton>(R.id.radioButtonYes)
        val radioButtonNo = findViewById<RadioButton>(R.id.radioButtonNo)

        nextButton.setOnClickListener {
            val intent = if (radioGroup.checkedRadioButtonId == radioButtonYes.id) {
                // "そう思う"が選択されている場合
                Intent(this, oshikatsuwoshiteiru::class.java)
            } else {
                // "そう思わない"が選択されている場合
                Intent(this, sotonomigasuki::class.java)
            }
            startActivity(intent)
        }
    }
}