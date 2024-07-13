package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class menusentaku : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menusentaku)

        val chatButton = findViewById<Button>(R.id.button_chat)
        chatButton.setOnClickListener {
            val intent = Intent(this, chatt::class.java)
            startActivity(intent)
        }

        val kaizenhouButton = findViewById<Button>(R.id.button_improvement)
        kaizenhouButton.setOnClickListener {
            val intent = Intent(this, kaizenhou_top::class.java)
            startActivity(intent)
        }

        val soudanButton = findViewById<Button>(R.id.button_consultation)
        soudanButton.setOnClickListener {
            val intent = Intent(this, soudan_top::class.java)
            startActivity(intent)
        }
    }
}