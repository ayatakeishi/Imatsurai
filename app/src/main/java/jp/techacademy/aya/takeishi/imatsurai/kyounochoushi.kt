package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class kyounochoushi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kyounochoushi)

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            Log.d("MainActivity", "Next button clicked")
            val intent = Intent(this, menusentaku::class.java)
            startActivity(intent)
        }
    }
}