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
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        emailEditText = findViewById(R.id.studentNumber)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(this, "メールアドレスを入力してください", Toast.LENGTH_SHORT).show()
            } else {
                val savedEmail = sharedPreferences.getString("userEmail", null)
                if (savedEmail == null || savedEmail != email) {
                    // 新しいメールアドレスの場合、SharedPreferencesをクリア
                    clearSharedPreferences()
                    saveEmail(email)
                    navigateToSeinengappiScreen()
                } else {
                    // 以前使用したことがある場合
                    navigateToNextScreenBasedOnFlag()
                }
            }
        }
    }

    private fun clearSharedPreferences() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    private fun saveEmail(email: String) {
        val editor = sharedPreferences.edit()
        editor.putString("userEmail", email)
        editor.apply()
    }

    private fun navigateToSeinengappiScreen() {
        val intent = Intent(this, seinengappi::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToNextScreenBasedOnFlag() {
        val hasAnsweredSutoresuhassanhou = sharedPreferences.getBoolean("answeredSutoresuhassanhou", false)
        val intent = if (hasAnsweredSutoresuhassanhou) {
            Intent(this, kyounochoushi::class.java)
        } else {
            Intent(this, sutoresuhassanhou::class.java)
        }
        startActivity(intent)
        finish()
    }
}

/**黄色の波線は「日本語辞めた方がいい」という警告。でも一応大丈夫。
 * keyは、発散法、valueはその答え
 * l63はブーリン式。intとかではない。ブーリンは答えが2択しかないもの。true or false
 * 質問に答えたかどうか？sutoresuhassanhouのl43と連動
 *
 *
 *
 */