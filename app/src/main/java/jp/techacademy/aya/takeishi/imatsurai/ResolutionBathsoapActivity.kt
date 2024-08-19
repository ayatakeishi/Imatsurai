package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResolutionBathsoapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolution_bathsoap)

        // WebViewの設定
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient() // 外部ブラウザではなくWebView内で表示
        webView.settings.javaScriptEnabled = true // 必要に応じてJavaScriptを有効に

        // TextViewのクリックリスナーを設定
        val textView = findViewById<TextView>(R.id.textView)
        textView.setOnClickListener {
            val url = "https://www.roselabo.jp/products/c/bath-products/"
            webView.loadUrl(url)
            webView.visibility = WebView.VISIBLE // WebViewを表示
            textView.visibility = TextView.GONE // textViewを非表示
        }

        // 新しく追加するリンクTextViewのクリックリスナー
        val linkTextView = findViewById<TextView>(R.id.linkTextView)
        linkTextView.setOnClickListener {
            val url = "https://www.roselabo.jp/products/c/bath-products/"
            webView.loadUrl(url)
            webView.visibility = WebView.VISIBLE // WebViewを表示
            linkTextView.visibility = TextView.GONE // linkTextViewを非表示
            textView.visibility = TextView.GONE // textViewも非表示
        }

        // 「メニュー選択画面に戻る」ボタンのクリックリスナーを設定
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            // MenuSelectActivityへ遷移
            val intent = Intent(this, MenuSelectActivity::class.java)
            startActivity(intent)
        }
    }
}
