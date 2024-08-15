package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MyfavoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myfavo)

        val nextButton = findViewById<Button>(R.id.nextButton)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButtonYes = findViewById<RadioButton>(R.id.radioButtonYes)
        val radioButtonNo = findViewById<RadioButton>(R.id.radioButtonNo)

        nextButton.setOnClickListener {
            val intent = if (radioGroup.checkedRadioButtonId == radioButtonYes.id) {
                // "はい"が選択されている場合
                Intent(this, ResolutionTearsActivity::class.java)
            } else {
                // "いいえ"が選択されている場合
                Intent(this, ResolutionCounselingActivity::class.java)
            }
            startActivity(intent)
        }
    }
}