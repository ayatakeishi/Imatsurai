package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class soudan_naiyou : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counseling_content)

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            // yoyakukakuteiアクティビティに遷移するためのインテントを発行
            val intent = Intent(this, CounselingConfActivity::class.java)
            startActivity(intent)
        }
    }
}