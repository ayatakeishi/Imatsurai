package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Kaiketsuhou_EigaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kaiketsuhou_eiga)

        // TextViewのクリックリスナーを設定
        val textView = findViewById<TextView>(R.id.textView)
        textView.setOnClickListener {
            val url = "https://www.tearsteacher.com/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}
