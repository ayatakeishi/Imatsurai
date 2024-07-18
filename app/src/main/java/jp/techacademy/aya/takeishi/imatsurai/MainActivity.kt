package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.studentNumber)
        nextButton = findViewById(R.id.nextButton)

        // 既にメールアドレスが保存されている場合
        if (getEmail() != null) {
            navigateToNextScreen()
        }

        nextButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if (email.isNotEmpty()) {
                saveEmail(email)
                navigateToNextScreen()
            } else {
                Toast.makeText(this, "メールアドレスを入力してください", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 次の画面に遷移する関数
    private fun navigateToNextScreen() {
        val intent = Intent(this, menusentaku::class.java)
        startActivity(intent)
        finish()
    }

    // メールアドレスを保存する関数
    private fun saveEmail(email: String) {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.apply()
    }

    // 保存されたメールアドレスを取得する関数
    private fun getEmail(): String? {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        return sharedPreferences.getString("email", null)
    }
}