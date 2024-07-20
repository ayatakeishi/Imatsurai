package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.studentNumber)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            navigateToNextScreen()
        }
    }

    // 次の画面に遷移する関数
    private fun navigateToNextScreen() {
        val intent = Intent(this, seinengappi::class.java)
        startActivity(intent)
        finish()
    }
}