package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val intent = Intent(this, SeinengappiActivity::class.java)
            startActivity(intent)
        }
    }
}