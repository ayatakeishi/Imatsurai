package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_select)

        val chatButton = findViewById<Button>(R.id.button_chat)
        chatButton.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        val kaizenhouButton = findViewById<Button>(R.id.button_improvement)
        kaizenhouButton.setOnClickListener {
            val intent = Intent(this, SelfFitTopActivity::class.java)
            startActivity(intent)
        }

        val soudanButton = findViewById<Button>(R.id.button_consultation)
        soudanButton.setOnClickListener {
            val intent = Intent(this, CounselingContentActivity::class.java)
            startActivity(intent)
        }
    }
}