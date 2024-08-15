package jp.techacademy.aya.takeishi.imatsurai

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResolutionTearsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolution_tears)

        // WebViewの設定
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient() // 外部ブラウザではなくWebView内で表示
        webView.settings.javaScriptEnabled = true // 必要に応じてJavaScriptを有効に

        // TextViewのクリックリスナーを設定
        val textView = findViewById<TextView>(R.id.textView)
        textView.setOnClickListener {
            val url = "https://www.tearsteacher.com/"
            webView.loadUrl(url)
            webView.visibility = WebView.VISIBLE // WebViewを表示
        }

        // 新しく追加するリンクTextViewのクリックリスナー
        val linkTextView = findViewById<TextView>(R.id.linkTextView)
        linkTextView.setOnClickListener {
            val url = "https://www.tearsteacher.com/"
            webView.loadUrl(url)
            webView.visibility = WebView.VISIBLE // WebViewを表示
        }
    }
}
