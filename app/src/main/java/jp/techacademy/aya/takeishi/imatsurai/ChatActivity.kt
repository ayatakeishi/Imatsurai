package jp.techacademy.aya.takeishi.imatsurai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        // ボタンのクリックリスナーを設定
        val backToMainButton = findViewById<Button>(R.id.backToMainButton)
        backToMainButton.setOnClickListener {
            val intent = Intent(this, MenuSelectActivity::class.java)
            startActivity(intent)
            finish() // 現在のアクティビティを終了

        }
    }
}