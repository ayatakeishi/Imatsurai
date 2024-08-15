package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResolutionCounselingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolution_counseling)

        // リンクTextViewのクリックリスナーを設定
        val linkTextView = findViewById<TextView>(R.id.linkTextView)
        linkTextView.setOnClickListener {
            // CounselingContentActivity へ遷移する
            val intent = Intent(this, CounselingContentActivity::class.java)
            startActivity(intent)
        }
    }
}

